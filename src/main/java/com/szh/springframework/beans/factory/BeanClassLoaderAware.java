package com.szh.springframework.beans.factory;

/**
 * Callback that allows a bean to be aware of the bean{@link ClassLoader class loader}; that is, the class loader used by the present bean factory to load bean classes.
 * 实现此接口，即能感知到所属的 ClassLoader
 * Created by szh on 2023-05-25
 *
 * @author szh
 */

public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);
}
