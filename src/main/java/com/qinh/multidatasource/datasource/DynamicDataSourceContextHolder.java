package com.qinh.multidatasource.datasource;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-05-18-1:02
 */
@Slf4j
public class DynamicDataSourceContextHolder {
    //用来隔离线程，用于存储切换的数据源
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDataSourceType(String dsType){
        log.info("切换到{}数据源",dsType);
        CONTEXT_HOLDER.set(dsType);
    }

    public static String getDataSourceType(){
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSourceType(){
        CONTEXT_HOLDER.remove();
    }

}
