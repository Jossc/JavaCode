package designpattern.observer.impl;

import lombok.Data;

/**
 * 抽象观察者
 *
 * @description:
 * @author: Crazy
 * @date: 2020/3/26 15:33
 */
@Data
public abstract class AbstractObserver {
    protected Subject subject;

    /**
     * 更新方法
     */
    public abstract void update();


    /**
     * 新增
     */
    public abstract void add();
}
