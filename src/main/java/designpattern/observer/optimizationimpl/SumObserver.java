package designpattern.observer.optimizationimpl;

/**
 * @description:
 * @author: Crazy
 * @date: 2020/3/26 21:44
 */
public class SumObserver extends AbstractObserver {

    public SumObserver(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("sum :" + (subject.getState() + 2));
    }
}
