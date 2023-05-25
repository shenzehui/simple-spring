package com.szh.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.DisposableBean;
import com.szh.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 定义销毁方法适配器(接口和配置)
 * 适配器类：目前销毁方法有两种：实现接口 DisposableBean 和配置信息 destroy-method
 * 销毁方法执行时，我们不希望还得关注都销毁类型的方法，它的使用上更希望是有一个统一的接口进行销毁，所以这里就新增了适配类，做统一处理。
 * Created by szh on 2023-05-25
 *
 * @author szh
 */

public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        // 2. 配置信息 destroy-method(判断是为了避免二次销毁)
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }

    }
}
