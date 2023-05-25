package com.szh.springframework.context.support;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.szh.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * 获取 Bean 工厂和加载资源
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        // 创建工厂对象
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        // 加载路径下的资源
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 资源配置加载操作
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

}
