package com.qinh.multidatasource.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-05-18-0:52
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceAnnotation {
    DataSourceType value() default DataSourceType.MASTER;
}
