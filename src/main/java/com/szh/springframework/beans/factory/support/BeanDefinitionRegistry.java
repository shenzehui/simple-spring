package com.szh.springframework.beans.factory.support;

import com.szh.springframework.beans.factory.config.BeanDefinition;

/**
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
