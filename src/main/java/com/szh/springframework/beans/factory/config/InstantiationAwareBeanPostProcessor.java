package com.szh.springframework.beans.factory.config;

import com.szh.springframework.beans.BeansException;

/**
 * Created by szh on 2023-05-31
 *
 * @author szh
 */

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
