package com.szh.springframework.aop;

/**
 * 类匹配类
 * Filter that restricts matching of a pointcut or introduction to a given set of target classes.
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public interface ClassFilter {
    /**
     * Should the pointcut apply to the given interface or target class?
     *
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);
}
