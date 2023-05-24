package com.szh.springframework.test;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.XmlUtil;
import com.szh.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.szh.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.szh.springframework.core.io.DefaultResourceLoader;
import com.szh.springframework.core.io.Resource;
import com.szh.springframework.test.bean.UserService;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import java.io.IOException;
import java.io.InputStream;

/**
 * 测试
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    /**
     * 解析 classpath 资源路径下的文件
     */
    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:spring.xml");
        InputStream inputStream = resource.getInputStream();
        Document document = XmlUtil.readXML(inputStream);
        System.out.println(document);
//        System.out.println(content);
    }

    /**
     * 通过指定文件路径的方式读取文件信息
     */
    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    /**
     * 通过 URL 获取资源文件(网上文件)
     */
    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    /**
     * 加载 xml 文件
     */
    @Test
    public void test_xml() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册 bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取 Bean 对象
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }


}
