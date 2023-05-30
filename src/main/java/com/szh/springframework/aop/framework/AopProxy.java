package com.szh.springframework.aop.framework;

/**
 * 代理抽象实现(JDK&Cglib)
 * 定义一个标准接口，用于获取代理类。因为具体实现代理的方式可以有 JDK 方式，也可以是 Cglib 方式，所以定义接口会更加方便管理实现类。
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public interface AopProxy {

    Object getProxy();
}
