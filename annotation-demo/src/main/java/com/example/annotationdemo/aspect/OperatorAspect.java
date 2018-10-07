package com.example.annotationdemo.aspect;

import com.example.annotationdemo.annotation.Test;
import jdk.management.resource.ResourceMeter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.beans.Expression;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author 夜羽 <416282949@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/10/7
 */
@Aspect
@Component
public class OperatorAspect {
    //execution(* *(..)) 匹配所有包，所有方法
    //execution(public * com.xx.xx.xxx.*(..)) 某某包下的所有类的所有公有方法
    //execution(* com.xx.xx..*.*(..))//后一个*代表的是类，前一个..*代表的是子包下面
    // @Pointcut("execution(* com.example.*(..))")
    //定义切点
    @Pointcut("@annotation(com.example.annotationdemo.annotation.Test)")
    public void AnnotationpointCut(){

    }
    @Before("AnnotationpointCut()")
    public void before(JoinPoint joinPoint){
        //逻辑
        Object[] args = joinPoint.getArgs();//获取连接点的方法入参列表
        System.out.println("连接点入参方法列表："+args.length);
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();//获取方法签名对象
        Method method = signature.getMethod();//获得方法对象
        //从方法上拿到注解
        Test annotation = method.getAnnotation(Test.class);
        //从注解上拿到值
        System.out.println("打印："+annotation.value()+"开始前"+method.getName());
    }

    @After("AnnotationpointCut()")
    public void after(){
        //如果你有自己的业务要写的话，你可以在某个方法里面写你的业务，
        // 比如记录操作日志，那么你就可以在@after方法里面写你的业务层代码。
        System.out.println("after方法执行");
    }
    @Around("AnnotationpointCut()")
    public Object  around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕通知开始之前：");
        Object resmsg = null;
        try {
            //获取连接点方法的返回值。
            resmsg = proceedingJoinPoint.proceed();
            System.out.println("_____-----"+resmsg);
            MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
            Method method = signature.getMethod();
            String name = method.getName();
            System.out.println(name+"-----------");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕通知结束");
        return resmsg;
    }
}
