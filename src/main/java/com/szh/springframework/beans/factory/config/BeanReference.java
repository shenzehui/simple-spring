package com.szh.springframework.beans.factory.config;

/**
 * bean 的引用
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
