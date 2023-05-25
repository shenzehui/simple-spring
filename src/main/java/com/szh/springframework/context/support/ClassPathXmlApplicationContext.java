package com.szh.springframework.context.support;

import com.szh.springframework.beans.BeansException;

/**
 * 应用上下文实现类
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configurations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    /**
     * 从 XMl 中加载 BeanDefinition，并刷新上下文
     *
     * @param configurations
     */
    public ClassPathXmlApplicationContext(String[] configurations) {
        this.configurations = configurations;
        refresh();
    }

    @Override
    protected String[] getConfigurations() {
        return configurations;
    }
}
