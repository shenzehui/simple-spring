package com.szh.springframework.beans.factory.support;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 * Created by szh on 2023-05-23
 *
 * @author szh
 */

public interface InstantiationStrategy {
    /**
     * 实例化方法
     *
     * @param beanDefinition
     * @param beanName
     * @param ctor           java.lang.reflect 包下的 Constructor 类，为了拿到符合入参信息相对应的构造函数
     * @param args           具体的入参信息
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
