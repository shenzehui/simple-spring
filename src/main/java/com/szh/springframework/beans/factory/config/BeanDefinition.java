package com.szh.springframework.beans.factory.config;

import com.szh.springframework.beans.PropertyValues;

/**
 * 用于定义 Bean 信息，将 Object 改为 Class 存放对象，这样就可以把 Bean 的实例化操作放到容器中处理了
 * <p>
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
}
