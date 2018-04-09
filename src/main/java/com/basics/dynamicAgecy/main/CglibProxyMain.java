package com.basics.dynamicAgecy.main;

import com.basics.agency.UserService;
import com.basics.agency.UserServiceImpl;
import com.basics.dynamicAgecy.CglibProxy;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @PACKAGE_NAME: com.basics.dynamicAgecy.main
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/9
 * @author: chenzhuo
 */
public class CglibProxyMain {
    public static void main(String []args){
        //生成代理类到本地
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "D:\\basicsCode\\JavaCode\\src\\main\\java\\com\\sun\\proxy\\");
        UserServiceImpl service = new UserServiceImpl();
        CglibProxy cp = new CglibProxy();
        UserService proxy = (UserService) cp.getProxy(service.getClass());
        proxy.add();
        proxy.sub();
        proxy.hello("hello");
        proxy.service("hello service");
        proxy.toString();
    }
}
