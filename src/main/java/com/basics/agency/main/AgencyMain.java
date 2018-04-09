package com.basics.agency.main;

import com.basics.agency.UserServiceImpl;
import com.basics.agency.MyInvocationHandler;
import com.basics.agency.UserService;

/**
 * @PACKAGE_NAME: com.basics.agency.main
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/9
 * @author: chenzhuo
 * 主方法
 */
public class AgencyMain {

    public static void main(String[]args) throws NoSuchFieldException, IllegalAccessException {
        //生成的代理类保存到磁盘
      /*  Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        props.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");*/
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",true);

        UserService service = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        UserService proxy = (UserService) handler.getProxy();
        proxy.add();
    }

}
