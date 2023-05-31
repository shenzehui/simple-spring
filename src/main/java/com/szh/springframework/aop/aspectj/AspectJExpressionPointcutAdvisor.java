package com.szh.springframework.aop.aspectj;

import com.szh.springframework.aop.Pointcut;
import com.szh.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * 实现 PointcutAdvisor，把切面 pointcut、拦截方法 advice 和具体的拦截表达式 expression 结合在一起
 * 这样就可以在 xml 的配置中定义一个 pointcutAdvisor 切面拦截器了。
 * Created by szh on 2023-05-31
 *
 * @author szh
 */

public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    /**
     * 切面
     */
    private AspectJExpressionPointcut pointcut;

    /**
     * 具体的拦截方法
     */
    private Advice advice;

    /**
     * 表达式
     */
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (pointcut == null) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

}
