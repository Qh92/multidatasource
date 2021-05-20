package com.qinh.multidatasource.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-05-18-1:20
 */
@Aspect
@Component
@Slf4j
public class DataSourceAspect {
    //切入点，对所有用到的这个注解的方法拦截
    @Pointcut("@annotation(com.qinh.multidatasource.datasource.DataSourceAnnotation)")
    public void dsPoint(){

    }

    //环绕通知，在方法执行前后调用
    @Around("dsPoint()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        //获取到方法上注解的属性值 dataSource.value().name()
        DataSourceAnnotation dataSoure = method.getAnnotation(DataSourceAnnotation.class);
        if (dataSoure != null){
            //将数据源类型存入到ThreadLocal中
            DynamicDataSourceContextHolder.setDataSourceType(dataSoure.value().name());
        }
        try {
            //返回的是执行方法
            return point.proceed();
        }finally {
            //销毁数据源，在执行方法之后
            log.info("销毁数据源");
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }

}
