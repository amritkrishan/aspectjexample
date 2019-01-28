package com.aop.accountservice;

import com.aop.accountservice.aspectj.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AccountServiceApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(AccountServiceApplication.class, args);
		Account acc=applicationContext.getBean(Account.class);
		acc.withdraw(100);
		acc.currentBalance();
	}

}

