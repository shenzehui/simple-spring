package com.szh.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * 定义 Advisor 访问者
 * Created by szh on 2023-05-31
 *
 * @author szh
 */

public interface Advisor {

    /**
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc.
     *
     * @return the advice that should apply if the pointcut matches
     * @see org.aopalliance.intercept.MethodInterceptor
     * @see BeforeAdvice
     */
    Advice getAdvice();
}
