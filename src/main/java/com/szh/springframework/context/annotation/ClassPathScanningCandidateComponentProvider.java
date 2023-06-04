package com.szh.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.szh.springframework.beans.factory.config.BeanDefinition;
import com.szh.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 处理对象扫描装配
 * Created by szh on 2023-06-04
 *
 * @author szh
 */

public class ClassPathScanningCandidateComponentProvider {

    /**
     * 通过这个方法就可以扫描到所有 @Component 注解的 Bean 对象
     *
     * @param basePackage
     * @return
     */
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        // 扫描到添加 @Component 注解的所有 Class
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
