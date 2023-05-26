package com.szh.springframework.beans.factory;

import com.szh.springframework.beans.BeansException;

/**
 * Created by szh on 2023-05-26
 *
 * @author szh
 */

public interface FactoryBean<T> {

    /**
     * 获取对象
     *
     * @return
     * @throws BeansException
     */
    T getObject() throws BeansException;

    /**
     * 获取对象类型
     *
     * @return
     */
    Class<?> getObjectType();

    /**
     * 是否单例对象
     *
     * @return
     */
    boolean isSingleton();
}
