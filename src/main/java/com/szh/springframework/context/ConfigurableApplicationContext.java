package com.szh.springframework.context;

import com.szh.springframework.beans.BeansException;

/**
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
