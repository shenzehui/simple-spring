package com.szh.springframework.beans.factory.config;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * 定义 BeanFactoryPostProcessor
 * 允许自定义修改 BeanDefinition 属性信息
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完毕后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
