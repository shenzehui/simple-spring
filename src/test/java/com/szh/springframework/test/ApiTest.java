package com.szh.springframework.test;

import com.szh.springframework.context.support.ClassPathXmlApplicationContext;
import com.szh.springframework.test.bean.UserService;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * 测试
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class ApiTest {

    @Test
    public void test_prototype() {
        // 1. 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取 Bean 对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        // 3. 配置 scope="prototype/singleton"
        // 不一样，说明原型模式生效
        System.out.println(userService01);  // com.szh.springframework.test.bean.UserService$$EnhancerByCGLIB$$f7d62903@78e117e3
        System.out.println(userService02);  // com.szh.springframework.test.bean.UserService$$EnhancerByCGLIB$$f7d62903@2ea227af

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());

    }

    /**
     * 代理对象
     */
    @Test
    public void test_factory_bean() {
        // 1. 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
