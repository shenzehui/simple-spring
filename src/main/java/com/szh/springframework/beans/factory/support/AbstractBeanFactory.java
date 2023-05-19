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
     *
     * @param name
     * @return
     */
    @Override
    public Object getBean(String name) {
        // 获取单例 bean 实例
        Object bean = getSingleton(name);
        // 存在，直接返回
        if (bean != null) {
            return bean;
        }
        // 不存在，检查是否注册，若有，直接返回，反之，抛出异常
        BeanDefinition beanDefinition = getBeanDefinition(name);
        // 通过反射创建 bean 的实例化，并加入到单例对象缓存中
        return createBean(name, beanDefinition);
    }

    /**
     * 根据名称获取 BeanDefinition
     *
     * @param name
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    /**
     * 根据 beanName() 和 beanDefinition(Class) 创建类实例并加入缓存
     *
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;


}
