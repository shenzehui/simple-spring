package com.szh.springframework.beans.factory.support;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.FactoryBean;
import com.szh.springframework.beans.factory.config.BeanDefinition;
import com.szh.springframework.beans.factory.config.BeanPostProcessor;
import com.szh.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.szh.springframework.util.ClassUtils;
import com.szh.springframework.util.StringValueResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象类定义模板方法
 * 继承 AbstractBeanFactory，具备了使用单例注册类方法
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    /**
     * ClassLoader to resolve bean class names with, if necessary
     */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /**
     * BeanPostProcessors to apply in createBean
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    /**
     * String resolvers to apply e.g. to annotation attribute values
     */
    private final List<StringValueResolver> embeddedValueResolvers = new ArrayList<>();

    /**
     * 获取单 bean，如果不存在会创建 bean
     * 这个方法将来会被调用获取实例
     */
    @Override
    public Object getBean(String name) {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    private <T> T doGetBean(final String name, final Object[] args) {
        // 获取单例 bean 实例
        Object sharedInstance = getSingleton(name);

        if (sharedInstance != null) {
            return (T) getObjectBeanInstance(sharedInstance, name);
        }
        // 不存在，检查是否注册，若有，直接返回，反之，抛出异常
        BeanDefinition beanDefinition = getBeanDefinition(name);
        // 通过 Cglib 创建类实例对象
        Object bean = createBean(name, beanDefinition, args);

        return (T) getObjectBeanInstance(bean, name);
    }

    /**
     * 对获取 FactoryBean 的操作
     *
     * @param beanInstance
     * @param beanName
     * @return
     */
    private Object getObjectBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        Object object = getCachedObjectForFactoryBean(beanName);
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }


    /**
     * 根据名称获取 BeanDefinition
     */
    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    /**
     * 根据 beanName() 和 beanDefinition(Class) 创建类实例并加入缓存
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;


    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    @Override
    public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
        this.embeddedValueResolvers.add(valueResolver);
    }

    @Override
    public String resolveEmbeddedValue(String value) {
        String result = value;
        for (StringValueResolver resolver : this.embeddedValueResolvers) {
            result = resolver.resolveStringValue(result);
        }
        return result;
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

}
