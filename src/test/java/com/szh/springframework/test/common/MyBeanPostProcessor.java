package com.szh.springframework.test.common;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.config.BeanPostProcessor;
import com.szh.springframework.test.bean.UserService;

/**
 * Created by szh on 2023-05-25
 *
 * @author szh
 */

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为:北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
