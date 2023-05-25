package com.szh.springframework.beans.factory.support;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.core.io.Resource;
import com.szh.springframework.core.io.ResourceLoader;

/**
 * bean 定义读取接口
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    /*------三个加载 bean 定义的方法-----------*/

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 加载资源路径下的 xml 文件
     *
     * @param location
     * @throws BeansException
     */
    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

}
