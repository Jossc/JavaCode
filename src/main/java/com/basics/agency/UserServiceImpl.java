package com.basics.agency;


/**
 * @PACKAGE_NAME: com.basics
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/9
 * @author: chenzhuo
 */
public class UserServiceImpl implements UserService {
    public void add() {
        System.err.println("-----------add -------------- ");
    }

    public void sub() {
        System.err.println("-----------sub -------------- ");
    }

    public void hello(String hello) {
        System.err.println("-----------hello -------------- " + hello);
    }

    public void service(String service) {
        System.err.println("-----------service -------------- " + service);
    }
}
