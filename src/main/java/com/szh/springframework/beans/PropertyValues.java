package com.szh.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性信息类的集合
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : propertyValueList) {
            if (pv.getValue().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }

}
