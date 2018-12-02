package com.jdk8.lmb.lam_interface.impl;

import com.jdk8.lmb.lam_interface.LamInterfaceTest;

/**
 * @ClassName InterfaceImpl
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class InterfaceImpl implements LamInterfaceTest {

    public String string ;


    public void setString(String string) {
        this.string = string;
    }

    public InterfaceImpl(){

    }

    public InterfaceImpl(LamInterfaceTest interfaceTest) {
        interfaceTest.getString();
    }

    public String getString() {
        return "hello Word";
    }

   public String getString(String s) {
        return s;
    }
}
