package com.jvm.bytecode;

import java.util.Random;

/**
 * @author by chenzhuo
 * @Description
 * @Date 2019/7/9 16:25
 **/
public class ClienteleImpl {

    public double after(double h, Clientele i) {
        return h * 0.8d;
    }
}

class ClinetChild extends ClienteleImpl implements Clientele {

    @Override
    public double after(double h, Clientele i) {
        // invokeinterface #2,  1
        // InterfaceMethod com/jvm/bytecode/Clientele.isVIP:()Z
        if (i.isVIP()) {
            //invokestatic
            return h * problem();
        }
        //invokespecial
        return super.after(h, i);

    }

    @Override
    public boolean isVIP() {
        return true;
    }

    public static double problem() {
        //invokespecial, 然后 invokevirtual
        return new Random().nextDouble()
                + 0.8d;
    }

    public static void main(String[] args) {
        ClinetChild clinetChild = new ClinetChild();
        clinetChild.after(100,clinetChild);
    }
}
