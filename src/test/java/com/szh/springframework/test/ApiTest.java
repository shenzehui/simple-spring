package com.szh.springframework.test;

import com.szh.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.szh.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.szh.springframework.context.support.ClassPathXmlApplicationContext;
import com.szh.springframework.test.bean.UserService;
import com.szh.springframework.test.common.MyBeanFactoryPostProcessor;
import com.szh.springframework.test.common.MyBeanPostProcessor;
import org.junit.Test;

/**
 * 测试
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class ApiTest {

    /**
     * 不应用上下文
     */
    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册 bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean 实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean 实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取 Bean 对象的调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("调用结果:" + result);
    }


    /**
     * 使用应用上下文
     */
    @Test
    public void test_xml() {
        // 1. 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        // 2. 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);

        String result = userService.queryUserInfo();
        System.out.println("调用结果:" + result);
    }


}
