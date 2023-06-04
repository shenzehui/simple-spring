package com.szh.springframework.stereotype;

import java.lang.annotation.*;

/**
 * 自定义拦截注解
 * Created by szh on 2023-06-04
 *
 * @author szh
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";

}
