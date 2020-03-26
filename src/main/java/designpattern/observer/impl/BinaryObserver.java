package designpattern.observer.impl;

import lombok.Data;

/**
 * @description:
 * @author: Crazy
 * @date: 2020/3/26 15:59
 */
@Data
public class BinaryObserver extends AbstractObserver {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: "
                + Integer.toBinaryString(subject.getState()));
    }

    @Override
    public void add() {

    }
}
