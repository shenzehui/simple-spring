package com.szh.springframework.beans.factory.support;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.BeanFactory;
import com.szh.springframework.beans.factory.config.BeanDefinition;

/**
 * 抽象类定义模板方法
 * 继承 AbstractBeanFactory，具备了使用单例注册类方法
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 获取单 bean，如果不存在会创建 bean
     * 这个方法将来会被调用获取实例
     */
    @Override
    public Object getBean(String name) {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    private <T> T doGetBean(final String name, final Object[] args) {
        // 获取单例 bean 实例
        Object bean = getSingleton(name);
        // 存在，直接返回
        if (bean != null) {
            return (T) bean;
        }
        // 不存在，检查是否注册，若有，直接返回，反之，抛出异常
        BeanDefinition beanDefinition = getBeanDefinition(name);
        // 通过 Cglib 创建类实例对象
        return (T) createBean(name, beanDefinition, args);
    }


    /**
     * 根据名称获取 BeanDefinition
     */
    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    /**
     * 根据 beanName() 和 beanDefinition(Class) 创建类实例并加入缓存
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;


}
