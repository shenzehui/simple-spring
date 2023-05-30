package com.szh.springframework.aop;

import java.lang.reflect.Method;

/**
 * 方法匹配
 * Part of a {@link Pointcut}: Checks whether the target method is eligible for advice.
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public interface MethodMatcher {

    /**
     * Perform static checking whether the given method matches. If this
     *
     * @param method
     * @param targetClass
     * @return whether or not this method matches statically
     */
    boolean matchers(Method method, Class<?> targetClass);

}
