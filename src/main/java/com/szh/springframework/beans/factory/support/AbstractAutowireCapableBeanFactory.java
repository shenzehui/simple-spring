package com.szh.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.PropertyValue;
import com.szh.springframework.beans.PropertyValues;
import com.szh.springframework.beans.factory.config.BeanDefinition;
import com.szh.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * 继承 AbstractBeanFactory 模板类，具有 AbstractBeanFactory 的所有功能，重写创建 bean 的方法
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    /**
     * 创建类实例
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 给 bean 填充属性
            applyProperties(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 添加实例对象到缓存中
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * 创建策略调用
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 获取构造函数的集合
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            // 对入参的数量和构造函数中的参数数量进行对比
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instance(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * 属性填充
     */
    protected void applyProperties(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            // 获取属性集合类
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            // 遍历所有属性
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                // 属性名
                String name = propertyValue.getName();
                // 属性值
                Object value = propertyValue.getValue();
                // 当值为类的引用的时候
                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    // fixme 循环依赖问题处理
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
