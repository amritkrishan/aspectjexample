package com.aop.accountservice.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FeatureAspect {

    @Pointcut("@annotation(featureType)")
    public void callAt(FeatureType featureType) {
    }

    @Around("callAt(featureType)")
    public Object around(ProceedingJoinPoint pjp, FeatureType featureType) throws Throwable {
        if (featureType.feature().name().equals("Withdrawal")) {
            System.out.println("Withdrawal Feature Execution");
            return pjp.proceed();
        } else if(featureType.feature().name().equals("BalanceEnquiry")) {
            System.out.println("Balance Enquiry Feature Execution");
            return pjp.proceed();
        }
        else {
            return pjp.proceed();
        }
    }

}
