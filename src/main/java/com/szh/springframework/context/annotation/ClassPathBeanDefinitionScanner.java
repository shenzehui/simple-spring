package com.szh.springframework.context.annotation;

import cn.hutool.core.util.StrUtil;
import com.szh.springframework.beans.factory.config.BeanDefinition;
import com.szh.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.szh.springframework.stereotype.Component;

import java.util.Set;

/**
 * 处理对象扫描装配
 * Created by szh on 2023-06-04
 *
 * @author szh
 */

public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {

    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    /**
     * 核心方法
     * 在 doScan 方法中处理所有指定路径下添加了注解的类，拆解出类的信息：名称、作用范围等，
     * 进行创建 BeanDefinition 好用于 Bean 对象的注册操作。
     * @param basePackages
     */
    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                // 解析 Bean 的作用域 singleton、prototype
                String beanScope = resolveBeanScope(beanDefinition);
                // 有作用域
                if (StrUtil.isNotEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
    }

    /**
     * 获取 BeanDefinition 的作用域
     *
     * @param beanDefinition
     * @return
     */
    public String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (null != scope) {
            return scope.value();
        }
        return StrUtil.EMPTY;
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isEmpty(value)) {
            // 类名开头小写
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }
}
