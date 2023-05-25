package com.szh.springframework.beans.factory.config;

import com.szh.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
