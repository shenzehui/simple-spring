package com.szh.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * Created by szh on 2023-06-04
 *
 * @author szh
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";
}
