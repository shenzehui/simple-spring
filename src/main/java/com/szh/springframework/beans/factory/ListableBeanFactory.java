package com.szh.springframework.beans.factory;

import com.szh.springframework.beans.BeansException;

import java.util.Map;

/**
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String,T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的 Bean 名称
     * @return
     */
    String[] getBeanDefinitionNames();


}
