package com.szh.springframework.test;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一级缓存解决循环依赖问题：
 * 流程：A对象的属性填充 B 对象时，如果缓存中不能获取 B 对象，则开始创建 B 对象，同样创建完成后，将 B 对象放入缓存中
 * 接下来对 B 对象进行属性填充时，恰好可以从缓存中获取半成品的 A 对象，B 对象属性填充完毕
 * 最后回来填充 A 对象，把实例化后并填充了属性的 B 对象赋值给 A 对象的 b 属性，这样就完成了一个循环依赖操作。
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class CircleTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        System.out.println(getBean(B.class).getA());
        System.out.println(getBean(A.class).getB());
        //com.szh.springframework.test.A@266474c2
        //com.szh.springframework.test.B@6f94fa3e
    }

    private final static Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    private static <T> T getBean(Class<T> beanClass) throws InstantiationException, IllegalAccessException {
        String beanName = beanClass.getSimpleName().toLowerCase();
        if (singletonObjects.containsKey(beanName)) {
            return (T) singletonObjects.get(beanName);
        }
        // 实例化对象入缓存
        Object obj = beanClass.newInstance();
        singletonObjects.put(beanName, obj);
        // 属性填充补全对象
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> fieldClass = field.getType();
            String fieldBeanName = fieldClass.getSimpleName().toLowerCase();
            field.set(obj, singletonObjects.containsKey(fieldBeanName) ? singletonObjects.get(fieldBeanName) : getBean(fieldClass));
            field.setAccessible(false);
        }
        return (T) obj;
    }

}


class A {

    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}

class B {

    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
