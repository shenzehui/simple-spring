package com.szh.springframework.test;

import com.szh.springframework.beans.factory.config.BeanDefinition;
import com.szh.springframework.beans.factory.BeanFactory;
import com.szh.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.szh.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * 测试
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3. 第一次获取 bean，会创建单例
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 4. 第二次获取 bean，直接从单例工厂获取
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();

    }
}
