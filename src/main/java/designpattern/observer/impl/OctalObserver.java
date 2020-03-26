package designpattern.observer.impl;



/**
 * @description:
 * @author: Crazy
 * @date: 2020/3/26 16:12
 */
public class OctalObserver extends AbstractObserver {

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }

    @Override
    public void add() {

    }
}
