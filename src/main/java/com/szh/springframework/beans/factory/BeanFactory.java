package com.szh.springframework.beans.factory;

/**
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public interface BeanFactory {

    /**
     * 获取 Bean 工厂中的缓存实例
     *
     * @param name
     * @return
     */
    Object getBean(String name);

}
