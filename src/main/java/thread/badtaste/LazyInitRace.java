package thread.badtaste;

import designpattern.observer.impl.Subject;
import net.jcip.annotations.NotThreadSafe;

/**
 * @author crazy
 * @title: LazyInitRace
 * @projectName JavaCode
 * @description: 惰性初始化, 非线程安全
 * @date 2020/6/1117:16
 */
@NotThreadSafe
public class LazyInitRace {

    private  Subject subject;

    private static Subject subject1 = getSubject();

    private static Subject getSubject() {
        return new Subject();
    }

    public static Subject getInstance() {
        return LazyInitRaceOne.subject;
    }

    public static class LazyInitRaceOne {
        private static Subject subject = new Subject();
    }


    /*public Subject getInstance() {
        if (subject == null) {
            subject = new Subject();
        }
        return subject;
    }*/

    
}
