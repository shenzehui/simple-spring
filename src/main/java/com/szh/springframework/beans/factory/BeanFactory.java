package com.szh.springframework.beans.factory;

import com.szh.springframework.beans.BeansException;

/**
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public interface BeanFactory {

    /**
     * 获取 Bean 工厂中的缓存实例
     *
     * @param name
     * @return
     */
    Object getBean(String name);

    /**
     * 可以方便的传递入参构造函数实例化
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

}
