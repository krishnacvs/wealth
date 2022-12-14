package com.cgi.wealth.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.cgi.wealth.service.AppUserService.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("MyAspect Before");
        System.out.println("Args "+ Arrays.asList(joinPoint.getArgs()));
        System.out.println("SourceLocation "+joinPoint.getSourceLocation());
    }

    @AfterReturning(pointcut = "execution(* com.cgi.wealth.service.AppUserService.*(..))",
    returning = "result")
    public void after(JoinPoint joinPoint, Object result){
        System.out.println("MyAspect Before");
        System.out.println("Args "+ Arrays.asList(joinPoint.getArgs()));
        System.out.println("result "+result);
    }
}
