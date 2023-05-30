package com.szh.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * 包装切面通知信息
 * 主要是用于把代理、拦截、匹配的各项属性包装到一个类中，方便在 Proxy 实现类进行使用。这和你的业务开发中包装入参是一个道理
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public class AdvisedSupport {

    /**
     * 被代理的目标对象
     * 是一个目标对象，在目标对象类中提供 Object 入参属性，以及获取目标类 TargetClass 信息。
     */
    private TargetSource targetSource;

    /**
     * 方法拦截器
     * MethodInterceptor 是一个具体拦截方法实现类，由用户自己实现 MethodInterceptor#invoke 方法，做具体的处理
     */
    private MethodInterceptor methodInterceptor;

    /**
     * 方法匹配器（检查目标方法是否符合通知条件）
     * 是一个匹配方法的操作，这个对象由 AspectJExpressionPointcut 提供服务。
     */
    private MethodMatcher methodMatcher;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
