package com.ey.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

public class LoggingAspect {
    private static int counter = 0;

    //Advice Method
    @Before("controllerMethod()")
    public void logCount() {
        //Log Something
        System.out.println("This many AccountsController calls have been made: " + ++counter);
    }

    @AfterReturning(value = "controllerMethod()", argNames = "jp")
    public void logSuccessAfter(JoinPoint jp) {
        System.out.println(jp.getSignature().getName() + " successfully executed");
    }

    @AfterThrowing(pointcut = "execution(* com.ey.controllers.AccountsController.*(..))", throwing = "error")
    public void logFailureAfter(JoinPoint jp, Throwable error) {
        System.out.println(jp.getSignature().getName() + " failed to execute");
        System.out.println("Error: " + error.getMessage() + Arrays.toString(error.getStackTrace()));
    }

    @Pointcut("execution(* com.ey.controllers.AccountsController.*(..))")
    public void controllerMethod() {
        //This is a Hook method. It does nothing (directly)
    }
}
