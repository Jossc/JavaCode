package designpattern.observer.optimizationimpl;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Crazy
 * @date: 2020/3/26 17:43
 */
@Data
public class Subject {

    private List<AbstractObserver> observers = new ArrayList<>();

    private int state;

    public List<AbstractObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<AbstractObserver> observers) {
        this.observers = observers;
    }

    public void addObserver(AbstractObserver observer) {
        observers.add(observer);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

    /**
     * 通知所有观察者
     */
    public void notifyAllObserver() {
        observers.stream().forEach(s -> s.update());
    }

}
