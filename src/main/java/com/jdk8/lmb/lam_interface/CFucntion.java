package com.jdk8.lmb.lam_interface;

@FunctionalInterface
public interface CFucntion<F,T> {
    T using(F from);
}
