package com.datastructure.stack;

import lombok.Data;
import net.jcip.annotations.NotThreadSafe;

/**
 * 可以扩容的stack实现
 *
 * @ClassName StackCapacityArray
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019/12/7 3:22 下午
 **/
@Data
@NotThreadSafe
public class StackCapacityArray<T> {

    private volatile int len;

    private volatile int count;

    /**
     * 默认数组
     */
    transient Object[] elementData = {};

    private int size;


    public StackCapacityArray(int len) {
        if (len > 0) {
            this.elementData = new Object[len];
        } else if (len == 0) {
            this.elementData = new Object[16];
        }
        this.len = len;
        this.count = 0;
    }

    /**
     * 添加元素
     *
     * @param object
     * @return
     */
    public boolean addElement(T object) {
        if (count == len) {
            elementData = capacityArray(elementData, 1);
            elementData[count] = object;
            ++count;
            return true;
        }
        elementData[count] = object;
        ++count;
        return true;
    }

    /**
     * 获取元素
     *
     * @param index 下标索引
     * @return
     */
    public T get(int index) {
        if (index < 0) {
            throw new RuntimeException("index must greater than 0");
        }
        if (index > elementData.length) {
            throw new RuntimeException("index must less than elementData length ");
        }
        return (T) elementData[index];
    }

    /**
     * 获取size
     *
     * @return 返回size
     */

    public int size() {
        return elementData.length;
    }

    /**
     * pop 元素
     *
     * @return object
     */
    public Object pop() {
        if (count == 0) {
            return null;
        }
        Object value = elementData[count - 1];
        --count;
        return value;
    }

    /**
     * 扩容数组
     *
     * @param oldArray 老的数组
     * @param multiple 扩容的倍数
     */
    public static Object[] capacityArray(Object[] oldArray, int multiple) {
        if (multiple < 1) {
            throw new RuntimeException("multiple must greater than 1");
        }
        int oldLen = oldArray.length;
        int newLen = oldLen + oldLen * multiple;
        Object[] newArray = new Object[newLen];
        System.arraycopy(oldArray, 0, newArray, 0, oldLen);
        return newArray;
    }

    public static void main(String[] args) {
        StackCapacityArray<String> stackCapacityArray = new StackCapacityArray<String>(1);
        stackCapacityArray.addElement("hhhh");
        stackCapacityArray.addElement("我不知道就想测试");
        String testValue = stackCapacityArray.get(0);
        System.out.println(testValue);
        System.out.println(stackCapacityArray.size());
    }
}
