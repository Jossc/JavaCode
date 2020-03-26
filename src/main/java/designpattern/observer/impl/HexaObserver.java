package designpattern.observer.impl;

/**
 * @description:
 * @author: Crazy
 * @date: 2020/3/26 16:24
 */
public class HexaObserver extends AbstractObserver {
    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: "
                + Integer.toHexString(subject.getState()).toUpperCase());
    }

    @Override
    public void add() {

    }
}
