package org.example.sq.part1.SmartHomeController.aop.validation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.sq.part1.SmartHomeController.repository.lightRepository.LightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class LightingValidationAspect {

    @Autowired
    LightRepository lightRepository;

    @Around("@annotation(ValidationId)")
    public Object validateId(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        List<Long> ids = new ArrayList<>();

        label: for (Object arg : args) {
            switch (arg) {
                case Long id -> {
                    ids.add(id);
                    break label;
                }
                case Long[] arrLong -> {
                    ids.addAll(Arrays.asList(arrLong));
                    break label;
                }
                default -> {}
            }
        }

        List<Long> validateIds = new ArrayList<>();
        for(Long id: ids){
            try{
                lightRepository.findById(id);
                validateIds.add(id);
            }catch (Exception e){
                throw new IllegalArgumentException("Id doesn't exist!");
            }
        }
        return joinPoint.proceed();
    }
}

