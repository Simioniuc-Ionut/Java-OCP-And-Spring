package org.example.sq.part1.ch6.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(2)
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut(value = "execution(* org.example.sq.ch6.services.*.*(..))")
    public void myPointcut() {
    }

    @Around("myPointcut()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("Aspect have been logged! Before");
        Object response = joinPoint.proceed();
        logger.info("After execution!");
        return response;
    }
}
