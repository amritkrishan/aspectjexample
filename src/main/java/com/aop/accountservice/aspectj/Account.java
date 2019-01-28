package com.aop.accountservice.aspectj;

import org.springframework.stereotype.Component;

@Component
public class Account {

    public Account(){
    }

    int balance = 200;

    @FeatureType(feature=FeatureType.Feature.Withdrawal)
    public boolean withdraw(int amount) {
        if (balance < amount) {
            return false;
        }
        balance = balance - amount;
        System.out.println("Money withdrawn");
        return true;
    }

    @FeatureType(feature=FeatureType.Feature.BalanceEnquiry)
    public void currentBalance(){
        System.out.println("Current Balance : "+this.balance);
    }
}