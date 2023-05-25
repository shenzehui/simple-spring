package com.szh.springframework.beans.factory;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.szh.springframework.beans.factory.config.BeanDefinition;
import com.szh.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
