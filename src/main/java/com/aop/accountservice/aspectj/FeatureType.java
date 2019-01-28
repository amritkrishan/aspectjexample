package com.aop.accountservice.aspectj;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface FeatureType{

    public enum Feature {
        None, Withdrawal, BalanceEnquiry;
    }

    Feature feature() default Feature.None;

}