package designpattern.observer.optimizationimpl;


import lombok.Data;

/**
 * @description:
 * @author: Crazy
 * @date: 2020/3/26 17:41
 */
@Data
public abstract class AbstractObserver {

    protected Subject subject;


    /**
     * 更新方法
     */
    public abstract void update();

}
