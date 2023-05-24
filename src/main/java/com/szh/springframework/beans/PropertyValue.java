package com.szh.springframework.beans;

/**
 * 定义属性信息类
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
