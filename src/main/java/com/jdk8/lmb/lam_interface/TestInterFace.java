package com.jdk8.lmb.lam_interface;

/**
 * @ClassName TestInterFace
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 *
 * {@link java.lang.FunctionalInterface}
 *  if an interface declares an abstract method overriding one of the
 *  public methods of {@code java.lang.Object}, that also does
 *  <em>not</em> count toward the interface's abstract method count
 **/
@FunctionalInterface
public interface  TestInterFace {
    void test(String stirng );

    /*void testOne();*/
    String toString();
}
