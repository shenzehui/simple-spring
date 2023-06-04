package com.szh.springframework.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.PropertyValues;
import com.szh.springframework.beans.factory.BeanFactory;
import com.szh.springframework.beans.factory.BeanFactoryAware;
import com.szh.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.szh.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.szh.springframework.util.ClassUtils;

import java.io.File;
import java.lang.reflect.Field;

/**
 * 自定义扫描注解
 * Created by szh on 2023-06-04
 *
 * @author szh
 */

public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    /**
     * 感知获取 beanFactory
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    /**
     * 核心方法
     * 主要用于处理类含有 @Value、@Autowired 注解的属性，进行属性信息的提取和设置。
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        // 1. 处理注解 @Value
        Class<?> clazz = bean.getClass();
        // 因为 AbstractAutowireCapableBeanFactory 类中默认使用 CGlib 创建对象，所以需要判断是否为 CGlib 创建对象，否则是不能正确拿到类信息的。
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;

        // 获取所有属性
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            if (null != valueAnnotation) {
                String value = valueAnnotation.value();
                // 解析字符串
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }
        // 2. 处理注解 @Autowired  @Qualifier
        for (Field field : declaredFields) {
            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            if (null != autowiredAnnotation) {
                Class<?> fieldType = field.getType();
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                String dependentBeanName = null;
                Object dependentBean = null;
                if (null != qualifierAnnotation) {
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                } else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

}
