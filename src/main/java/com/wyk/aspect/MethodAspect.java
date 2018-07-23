package com.wyk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by wyk on 2018/3/3.
 */
@Component
@Aspect
public class MethodAspect {
    //* com.wyk.controller.*.*(..)
    @Pointcut("execution(* com.wyk.controller.*.*(..))")
    public void fo(){

    }

    @Around("fo()")
    public Object asd(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        String kind = proceedingJoinPoint.getKind();
        System.out.println(kind);
        Signature signature = proceedingJoinPoint.getSignature();
        System.out.println(signature);
        SourceLocation sourceLocation = proceedingJoinPoint.getSourceLocation();
        System.out.println(sourceLocation);
        JoinPoint.StaticPart staticPart = proceedingJoinPoint.getStaticPart();
        System.out.println(staticPart);
        Object aThis = proceedingJoinPoint.getThis();
        System.out.println(aThis);
        return proceedingJoinPoint.proceed();
    }
}