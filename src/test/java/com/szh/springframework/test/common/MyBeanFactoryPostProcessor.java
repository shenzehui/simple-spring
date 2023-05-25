package com.szh.springframework.test.common;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.PropertyValue;
import com.szh.springframework.beans.PropertyValues;
import com.szh.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.szh.springframework.beans.factory.config.BeanDefinition;
import com.szh.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * Created by szh on 2023-05-25
 *
 * @author szh
 */

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
