package com.szh.springframework.beans.factory.support;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.config.BeanDefinition;

/**
 * 继承 AbstractBeanFactory 模板类，具有 AbstractBeanFactory 的所有功能，重写创建 bean 的方法
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            // 通过反射创建 bean 的实例化
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // 添加实例对象到缓存中
        addSingleton(beanName, bean);
        return bean;
    }
}
