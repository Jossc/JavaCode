package com.jdk8.lmb.lam_interface;

@FunctionalInterface
public interface CFunction<F,T> {
    T using(F from);
}
