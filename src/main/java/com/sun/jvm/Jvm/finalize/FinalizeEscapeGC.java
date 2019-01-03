package com.sun.jvm.Jvm.finalize;

/**
 * @ClassName FinalizeEscapeGC
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * Finalize导致gc失效
 * finalize 放在 finalize-Queue中 在一个低级的线程中执行
 * finalize() 只能被执行一次
 * finalize的执行流程：
 *  finalize流程：当对象变成(GC Roots)不可达时,GC会判断该对象是否覆盖了finalize方法,
 *  若未覆盖,或则已经执行完finalize方法
 *  则直接将其回收.否则,若对象未执行过finalize方法,将其放入F-Queue队列,
 *  由一低优先级线程执行该队列中对象的finalize方法.
 *  执行finalize方法完毕后,GC会再次判断该对象是否可达,若不可达,则进行回收,否则,对象"复活".
 * 对象可由两种状态,涉及到两类状态空间,一是终结状态空间 F = {unfinalized, finalizable, finalized};
 *      二是可达状态空间 R = {reachable, finalizer-reachable, unreachable}.各状态含义如下：
 *      unfinalized: 新建对象会先进入此状态,GC并未准备执行其finalize方法,因为该对象是可达的(没有执行finalize,系统也不准备执行. )
 *
 *      finalizable: 表示GC可对该对象执行finalize方法,GC已检测到该对象不可达.正
 *                  如前面所述,GC通过F-Queue队列和一专用线程完成finalize的执行
 *                  (可以执行finalize了,系统会在随后的某个时间执行finalize.)
 *      finalized: 表示GC已经对该对象执行过finalize方法
 *
 *      reachable: 表示GC Roots引用可达
 *
 *      finalizer-reachable(f-reachable)：表示不是reachable,但可通过某个finalizable对象可达,
 *                  除了reachable外,从F-Queue可以通过引用到达的对象.
 *                  
 *      unreachable：对象不可通过上面两种途径可达(reachable,finalizer-reachable)
 *finalize问题:
 *  finalize-Queue是由一个低级的线程去执行的,jvm不保证这个一定会执行完,
 *  因为finalize-Queue在执行的时候可能出现了死循环,会导致整个回收系统的奔溃
 *
 **/
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("我还存活");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("执行 finalize");
        //对象的状态由unreachable变成reachable,就是对象复活
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {

        //当前状态是新建 unfinalized
        SAVE_HOOK = new FinalizeEscapeGC();
        //第一次自救成功
        //对象为null,就变成了不可达,finalizable
        //从unfinalized --- 变成了 finalizable
        SAVE_HOOK = null;
        //finalizable 执行过gc
        //添加到f-queue中
        //然后变成了finalizer-reachable 队列可达
        System.gc();
        Thread.sleep(500);
        if (null != SAVE_HOOK) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("SAVE_HOOK 已经被回收");
        }

        //第二次自救失败
        SAVE_HOOK = null;
        //这里系统已经标记过了,所以回收 第二次回收失败
        System.gc();
        Thread.sleep(500);
        if (null != SAVE_HOOK) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("11111SAVE_HOOK 已经被回收");
        }
    }
}
