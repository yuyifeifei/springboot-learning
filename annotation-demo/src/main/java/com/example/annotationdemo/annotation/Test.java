package com.example.annotationdemo.annotation;

import java.lang.annotation.*;

/**
 * @Description
 * @Author 夜羽 <416282949@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/10/7
 */
@Target({ElementType.METHOD,ElementType.TYPE})//作用于类和方法上
@Retention(RetentionPolicy.RUNTIME) //运行时
@Documented
public @interface Test {
    String value();
}
