package com.szh.springframework.util;

/**
 * 定义解析字符串接口
 * Created by szh on 2023-06-04
 *
 * @author szh
 */

public interface StringValueResolver {

    /**
     * 解析字符串操作
     * @param strVal
     * @return
     */
    String resolveStringValue(String strVal);

}
