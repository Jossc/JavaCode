package com.sun.jvm.Jvm;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import java.util.Map;

/**
 * @ClassName CglibBean
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class CglibBean {
    private  Object object ;
    private BeanMap beanMap;

    public CglibBean(){
        super();
    }
    public CglibBean(Map<String, Class<?>> propertyMap) {
        this.object = generateBean(propertyMap);
        this.beanMap = BeanMap.create(this.object);
    }
    public CglibBean(Object object,BeanMap beanMap){
        this.object = object;
        this.beanMap = beanMap;
    }

    public void setVaule(String property, Object value){
        beanMap.put(property,value);
    }
    /**
     * 通过属性名得到属性值
     *
     * @param property 属性名
     * @return 值
     */
    public Object getValue(String property) {
        return beanMap.get(property);
    }
    private Object generateBean(Map<String, Class<?>> propertyMap) {
        if (propertyMap == null || propertyMap.isEmpty()) {
            return null;
        }
        BeanGenerator generator = new BeanGenerator();
        for (Map.Entry<String, Class<?>> entry : propertyMap.entrySet()) {
            generator.addProperty(entry.getKey(), entry.getValue());
        }

        return generator.create();
    }
}
