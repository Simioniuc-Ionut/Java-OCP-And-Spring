package org.example.sq.part1.SmartHomeController.aop.audit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@within(ToLog)")
    public Object logg(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        Object[] args = joinPoint.getArgs();

        Object result;
        logger.info(() -> "\n BEFORE execution || Class name: " + className + " Starting method: " + methodName + " with args: " + Arrays.toString(args));
        try {
            result = joinPoint.proceed();
            logger.warning(() -> "\n RESULT execution || " + " result: " + result);
            logger.info(() -> "\n AFTER execution ||  Class name: " + className + "Completed method: " + methodName);
        } catch (Throwable ex) {
            logger.severe(() -> "\n ERROR!! Class name: " + className + "Exception in method: " + methodName + " -> " + ex.getMessage());
            throw ex;
        }
        return result;
    }
}
