package com.aop.accountservice.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {

    @Pointcut("execution(* withdraw(..))")
    public void executionPointCut() {
    }

    @Pointcut("within(com.aop.accountservice.aspectj..*)")
    public void withinPointCut() {
    }

    @Before(value = "executionPointCut() and args(amount)")
    public void callWithdraw(JoinPoint joinPoint, int amount) {
        System.out.println("Executing withdraw function with argument : "+amount);
    }

    @Before(value = "withinPointCut()")
    public void withinAccount(JoinPoint joinPoint) {
        System.out.println("Inside Aspectj Package");
    }
}