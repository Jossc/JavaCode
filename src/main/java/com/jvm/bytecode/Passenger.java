package com.jvm.bytecode;

/**
 * @author by chenzhuo
 * @Description
 * @Date 2019/7/9 14:06
 **/
abstract class Passenger {
    abstract void passThroughImmigration();

    @Override
    public String toString() {
        return super.toString();
    }
}

class Fore extends Passenger {

    @Override
    void passThroughImmigration() {
        System.out.println("do some");
    }
}

class Chinese extends Passenger {

    @Override
    void passThroughImmigration() {
        System.out.println("chinese do some");
    }

    void visitDutyFreeShop() {
        System.out.println("chinese do visitDutyFreeShop");
    }

    public static void main(String[] args) {
        Passenger passenger = new Chinese();
        passenger.passThroughImmigration()
        ;
    }
}