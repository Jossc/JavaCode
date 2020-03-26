package designpattern.observer.optimizationimpl;

/**
 * @description:
 * @author: Crazy
 * @date: 2020/3/26 21:47
 */
public class Demon {

    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.setState(3);
        new AddObserver(subject);
        new SumObserver(subject);
        System.out.println("First state change: 3");
        subject.setState(96);
        subject.setState(100);
        System.out.println("First state change: 96");
    }
}
