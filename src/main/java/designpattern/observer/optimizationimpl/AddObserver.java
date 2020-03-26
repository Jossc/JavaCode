package designpattern.observer.optimizationimpl;

/**
 * @description:
 * @author: Crazy
 * @date: 2020/3/26 21:39
 */
public class AddObserver extends AbstractObserver {

    public AddObserver(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }


    @Override
    public void update() {
        System.out.println("add :" + (subject.getState() + 1));
    }
}
