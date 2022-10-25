package com.ey.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SecurityAspect {
    @Around("secureMethod()")
    public Object employeeAuthenticate(ProceedingJoinPoint pjp) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String auth = request.getHeader("employee_authorizer");
        System.out.println(auth);

        if(("employee").equals(auth)) {
            return pjp.proceed();
        } else {
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }

//        System.out.println("Before Method");
//        pjp.proceed();
//        System.out.println("After Method");
//
//        return new ResponseEntity<>(true, HttpStatus.OK);
    }



    @Pointcut("@annotation(com.ey.aspects.Authorized)")
    public void employeeSecureMethod() {

    }
    @Around("secureMethod()")
    public Object adminAuthenticate(ProceedingJoinPoint pjp) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String auth = request.getHeader("admin_authorizer");
        System.out.println(auth);

        if(("admin").equals(auth)) {
            return pjp.proceed();
        } else {
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }

//        System.out.println("Before Method");
//        pjp.proceed();
//        System.out.println("After Method");
//
//        return new ResponseEntity<>(true, HttpStatus.OK);
    }



    @Pointcut("@annotation(com.ey.aspects.Authorized)")
    public void adminSecureMethod() {

    }

}
