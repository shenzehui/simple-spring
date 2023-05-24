package com.szh.springframework.beans.factory.support;

import com.szh.springframework.core.io.DefaultResourceLoader;
import com.szh.springframework.core.io.ResourceLoader;

/**
 * Bean 定义抽象类实现
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    /**
     * 提供了构造函数，让外部的调用使用，把 Bean 定义注入类，传递进来
     */
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
