package cn.vector.girl.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-5-30 9:32
 */
@Slf4j
@Aspect
@Component
public class HttpAspect {
    // private final static Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
    @Pointcut("execution(public * cn.vector.girl.controller.GirlController.*(..))")
    public void log(){
        log.info("do Method:{}",Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        log.info("do Method:{}",Thread.currentThread().getStackTrace()[1].getMethodName());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        log.info("url={}",request.getRequestURL());
        //method
        log.info("method={}",request.getMethod());
        //ip
        log.info("ip={}", request.getRemoteAddr());
        //类方法
        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."
                +joinPoint.getSignature().getName());
        //参数
        log.info("args={}", joinPoint.getArgs());

    }
    @After("log()")
    public void doAfter(){
        log.info("do Method:{}",Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        log.info("response={}",object.toString());
    }
}
