package com.szh.springframework.beans.factory.support;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * JDK 实例化
 * Created by szh on 2023-05-23
 *
 * @author szh
 */

public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        // 通过 beanDefinition 获取 Class 信息，这个 Class 信息是在 bean 定义的时候传递进去的
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                // 有构造函数实例化
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                // 无构造函数实例化
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
