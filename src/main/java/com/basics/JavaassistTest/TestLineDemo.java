package com.basics.JavaassistTest;

import sun.misc.Contended;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * PACKAGENAME: com.basics.JavaassistTest
 * USER : chenzhuo
 * MONTH_NAME_SHORT: 八月
 * 1.8缓存行
 *  sun.misc.Contended("tlr")
 * @link @Contended
 **/
public class TestLineDemo {
    @Contended
    String name;

    @Contended
    String value;

    public static void main(String[] args) {
      /*  try{
            Socket socket=new Socket("",8080);
            System.out.println("client start ...");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter write=new PrintWriter(socket.getOutputStream());
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String readline;
            readline=br.readLine();
            while(!readline.equals("end")){
                write.println(readline);
                write.flush();
                System.out.println("Client:"+readline);
                System.out.println("Server:"+in.readLine());
                readline=br.readLine();
            }
            write.close();
            in.close();
            socket.close();
        }catch(Exception e) {
            System.out.println("can not listen to:"+e);
        }*/
    }

}
