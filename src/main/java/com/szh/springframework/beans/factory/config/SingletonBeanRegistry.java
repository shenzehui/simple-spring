package com.szh.springframework.beans.factory.config;

/**
 * 单例注册接口定义
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public interface SingletonBeanRegistry {

    /**
     * 获取单例对象
     *
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    /**
     * 注册单例
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName, Object singletonObject);

}
