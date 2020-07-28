package com.itheima.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect //标注当前Aspect是一个切面
public class MyAspect {

    //定义茄蒂表达式
    @Pointcut("execution(* com.itheima.anno.*.*(..))")
    public void pointcut(){}

    //配置前置增强
    @Before("pointcut()")
    public void before(){
        System.out.println("前置增强....");
    }

    @AfterReturning("MyAspect.pointcut()")
    public void afterReturning(){
        System.out.println("后置增强....");
    }

    //ProceedingJoinPoint 正在执行的连接点===切点
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强...");
        Object process = pjp.proceed();//切点方法
        System.out.println("环绕后增强...");
        return process;
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("异常抛出增强....");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("最终增强...");
    }
}
