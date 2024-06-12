package com.sparta.junit5practice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component

public class ParameterAOP {

    // 컨트롤러 하위 패키지 모슨 메서드를 다 aop로 적용
    @Pointcut("execution(* com.sparta.junit5practice.controller..*.*(..))")
    private void cut() {
    }
    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("====before====");
        Object[] args = joinPoint.getArgs();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); // 메서드 가져오기
        Method method = methodSignature.getMethod(); // 메서드 가져오기
        System.out.println("method : " + method.getName()); // 메서드 이름 가져오기


        for (Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }
    @AfterReturning(value = "cut()", returning = "returnobj")
    public void afterReturn(JoinPoint joinPoint, Object returnobj) {
        System.out.println("returnobj");
        System.out.println(returnobj);
    }
}
