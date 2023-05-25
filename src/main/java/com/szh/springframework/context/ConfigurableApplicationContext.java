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
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 虚拟机关闭钩子注册调用销毁方法
     */
    void registerShutdownHook();

    /**
     * 手动执行关闭方法
     */
    void close();

}
