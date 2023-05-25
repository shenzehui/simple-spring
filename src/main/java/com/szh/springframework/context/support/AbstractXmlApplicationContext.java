package com.szh.springframework.context.support;

import com.szh.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.szh.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configurations = getConfigurations();
        if (null != configurations) {
            beanDefinitionReader.loadBeanDefinitions(configurations);
        }

    }

    protected abstract String[] getConfigurations();
}
