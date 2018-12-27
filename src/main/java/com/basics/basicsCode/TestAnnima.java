package com.basics.basicsCode;

/**
 * PACKAGE_NAME: com.basics.basicsCode
 * MONTH_NAME_SHORT: 十月
 * USER: Clement
 **/
public class TestAnnima implements Annima{

    /**
     * Annima annima = new TestAnnima();
     * Class<TestAnnima> testAnnimaClass = TestAnnima.class;
     * TestAnnima ca = testAnnimaClass.cast(annima);
     * 等价于
     * TestAnnima testAnnima = (TestAnnima) annima;
     * testAnnima.sayHello();
     * @param args
     */
    public static void main(String[] args) {
        Annima annima = new TestAnnima();
        Class<TestAnnima> testAnnimaClass = TestAnnima.class;
        TestAnnima ca = testAnnimaClass.cast(annima);
        ca.sayHello();

     /*   TestAnnima testAnnima = (TestAnnima) annima;

        testAnnima.sayHello();*/


    }

    @Override
    public void sayHello() {
        System.out.println("say-- hello" );
    }
}
