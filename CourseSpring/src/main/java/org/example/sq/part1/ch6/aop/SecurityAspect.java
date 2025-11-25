package org.example.sq.part1.ch6.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(1)
public class SecurityAspect {
    private Logger logger =
            Logger.getLogger(SecurityAspect.class.getName());

    @Around("execution(* org.example.sq.ch6.services.*.*(..))")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.warning("Secure Layer");
        Object response = joinPoint.proceed();
        logger.warning("After Secure Layer");
        return response;
    }
}
