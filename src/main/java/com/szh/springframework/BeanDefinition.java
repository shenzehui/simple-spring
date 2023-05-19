package com.szh.springframework;

/**
 * 用于定义 Bean 实例化信息，现在实现的是一个 Object 存放对象
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
