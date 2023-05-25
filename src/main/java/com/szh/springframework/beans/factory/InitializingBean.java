package com.szh.springframework.beans.factory;

import com.szh.springframework.beans.BeansException;

/**
 * 定义初始化接口+
 * Created by szh on 2023-05-25
 *
 * @author szh
 */

public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     */
    void afterPropertiesSet() throws BeansException;
}
