package designpattern.observer.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * 聚焦类
 *
 * @description:
 * @author: Crazy
 * @date: 2020/3/26 15:30
 */

public class Subject {

    private List<AbstractObserver> observerList = new ArrayList<>();

    private int state;

    public List<AbstractObserver> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<AbstractObserver> observerList) {
        this.observerList = observerList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    /**
     * 添加观察者
     *
     * @param observer
     */
    public void attach(AbstractObserver observer) {
        observerList.add(observer);
    }

    public void notifyAllObservers() {
        observerList.stream().forEach(state -> state.update());
    }
}
