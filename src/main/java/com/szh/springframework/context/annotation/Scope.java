package com.szh.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * 定义拦截注解
 * <p>
 * 用于配置作用域的自定义注解，方便通过配置 Bean 对象注解的时候，拿到 Bean 对象的作用域。
 * Created by szh on 2023-06-04
 *
 * @author szh
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";

}
