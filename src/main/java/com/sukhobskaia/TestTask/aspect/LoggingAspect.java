package com.sukhobskaia.TestTask.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.sukhobskaia.TestTask.repositories.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method call: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.sukhobskaia.TestTask.repositories.*.*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method {} completed. Result: {}",
                joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(pointcut = "execution(* com.sukhobskaia.TestTask.repositories.*.*(..))",
            throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("Method error {} : {}",
                joinPoint.getSignature().getName(), error.getMessage());
    }
}