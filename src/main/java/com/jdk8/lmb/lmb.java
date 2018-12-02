package com.jdk8.lmb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

/**
 * @ClassName lmb
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class lmb {
    private static Logger logger =
            LoggerFactory.getLogger(lmb.class);
    public static void main(String[] args) {
        JFrame frame = new JFrame("lm");
        JButton jButton = new JButton("s");
        jButton.addActionListener(event->
            System.out.println("e" + event.getModifiers())
        );
        frame.add(jButton);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
