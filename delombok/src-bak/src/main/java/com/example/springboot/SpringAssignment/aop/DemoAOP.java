package com.example.springboot.SpringAssignment.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Aspect
@Configuration
public class DemoAOP {
    private Logger logger= Logger.getLogger(DemoAOP.class.getName());

    @Before("execution(* com.example.springboot.SpringAssignment.dao.*.*(..))")
    public void before(JoinPoint joinPoint){
        logger.info("calling function of " +joinPoint.getSignature().toShortString());
    }


}
