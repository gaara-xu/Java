package com.src.aspect;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.aspectj.lang.JoinPoint;
/**
 * Created by Gaara_Xu
 * on 2017/9/6.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Before("execution(public * com.src.controller.GirlController.girllist(..))")
    //@Before("execution(public * com.src.controller.GirlController.*(..))")
    public void log(){
        System.out.println("!!!!!!!!!!");
    }

    @After("execution(public * com.src.controller.GirlController.girllist(..))")
    public void doAfter(){
        System.out.println(222222222);
    }

    @Pointcut("execution(public * com.src.controller.GirlController.*(..))")
    public void dolog(){
        System.out.println("this is sout and do log");
    }
    @After("dolog()")
    public void thisnewAfter(){
        logger.info("this is log after");
    }
    @Before("dolog()")
    public void thisnewBefore(JoinPoint joinPoint){
        logger.info("this is log before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());

        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类名  方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getDeclaringType());
        //参数
        logger.info("args={}",joinPoint.getArgs());

    }

    @AfterReturning(returning = "object",pointcut = "dolog()")
    public void afterrerurn(Object object){
        logger.info("response={}",object);
    }



}
