package com.szh.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * Created by szh on 2023-06-04
 *
 * @author szh
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();
}
