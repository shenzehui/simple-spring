package com.szh.springframework.beans.factory.support;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实现一个 FactoryBean 注册服务
 * FactoryBeanRegistrySupport 类主要处理的就是关于 FactoryBean 此类对象的注册操作
 * Created by szh on 2023-05-26
 *
 * @author szh
 */

public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    /**
     * 用于存放单例类型的对象，也就是 FactoryBean 泛型所指的对象
     * Cache of singleton objects created by FactoryBeans: FactoryBean name --> object
     */
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return object != NULL_OBJECT ? object : null;
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
            }
            return (object != null ? object : NULL_OBJECT);
        } else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName) {
        try {
            return factory.getObject();
        } catch (BeansException e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }

}
