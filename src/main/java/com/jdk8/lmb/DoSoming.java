package com.jdk8.lmb;

import com.jdk8.lmb.lam_interface.CFunction;
import com.jdk8.lmb.lam_interface.User;

/**
 * @ClassName DoSoming
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class DoSoming {
    DoSoming(){

    }
    String startsWith(String s) {
        return s;
    }

    public static void main(String[] args) {
        DoSoming soming = new DoSoming();
        CFunction<String,String> cFucntion = soming::startsWith;
        String sing = cFucntion.using("Demons");
        System.out.println("sing : "+sing);
        System.out.println("classe:"+ cFucntion.getClass().getInterfaces()[0]);
        User user = new User();
        CFunction<User,String> fucntion = User::getUserName;
        fucntion.using(user);



    }

}
