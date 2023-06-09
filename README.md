<h1 align="center">
  造轮子项目 — 从头实现Spring框架
</h1>

![image-20230519202118750](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/image-20230519202118750.png)

## Bean 的生命周期

![图 9-3](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/spring-9-03.png)

## 基于Cglib实现含构造函数的类实例化策略

![step3](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/step3.png)

## 为Bean对象注入属性和依赖Bean的功能实现

![image-20230530151938030](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/image-20230530151938030.png)

## 实现资源加载器解析与文件注册对象

![step5](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/step5.png)

## 实现应用上下文

![step6](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/step6.png)

## 初始化和销毁方法

![step7](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/step7.png)

## Aware感知容器

![image-20230530171826018](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/image-20230530171826018.png)

## 关于Bean对象作用域以及FactoryBean的实现和使用

![step9](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/step9.png)

## 基于观察者实现，容器事件和事件监听器

![step10](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/step10.png)

## 基于JDK和Cglib动态代理，实现AOP核心功能

![step11](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/step11.png)

## 借着 BeanPostProcessor把动态代理融入到Bean的生命周期中

![step12](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/step12.png)


## 利用自定义注解 实现Bean的自动化扫描注册

![step13](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/step13.png)

## 在实现自动扫描带@Component注解的对象自动装配和注册的基础上，可以使用@Autowired、@Value注解，完成对属性和对象的注入操作

![step14](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/step14.png)

## Spring中应用的设计模式

 ![image-20230609195559559](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/image-20230609195559559.png)

- 工厂模式：Spring 容器本质是一个大工厂，使用工厂模式通过 BeanFactory、ApplicationContext 创建 bean 对象。
- 代理模式：Spring AOP 功能就是通过代理模式来实现的，分为动态代理和静态代理。
- 单例模式：Spring 中的 Bean 默认都是单例的，这样有利于容器对 Bean 的管理。
- 模板模式：Spring 中 JdbcTemplate、RestTemplate 等以 Template 结尾的对数据库、网络等进行操作的模板类，就使用到了模板模式。
- 观察者模式：Spring 事件驱动模型就是观察者模式很经典的一个应用。
- 适配器模式：Spring AOP 的增强或通知（Advice）使用到了适配器模式、Spring MVC 中也是用到了适配器模式适配 Controller。
- 策略模式：Spring 中有一个 Resource 接口，它的不同实现类，会根据不同的策略去访问资源。
