package com.basics.SqlConnectionPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ConnectionDriver
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/10/10 10:16
 * @Version 1.0
 **/
public class ConnectionDriver {
    static  class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().equals("commit")){
                TimeUnit.MICROSECONDS.sleep(100);
            }
            return null;
        }
    }
    // 创建一个Connection的代理，在commit时休眠100毫秒
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
                new Class[] { Connection.class }, new ConnectionHandler());
    }
}
