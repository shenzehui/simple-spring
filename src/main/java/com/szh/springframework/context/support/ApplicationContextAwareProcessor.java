package com.szh.springframework.context.support;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.ApplicationContextAware;
import com.szh.springframework.beans.factory.config.BeanPostProcessor;
import com.szh.springframework.context.ApplicationContext;

/**
 * 包装处理器
 * Created by szh on 2023-05-25
 *
 * @author szh
 */

public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 由于 ApplicationContext 的获取并不能直接在创建 Bean 的时候就可以拿到，所以需要在 refresh 操作时，
     * 把 ApplicationContext 写入到一个包装的 BeanPostProcessors 中去，再由 AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization 方法调用。
     *
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
