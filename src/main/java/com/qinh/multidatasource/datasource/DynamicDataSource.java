package com.qinh.multidatasource.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-05-18-1:06
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object,Object> targetDataSource) {

        log.info("DynamicDataSource加载数据源...........");
        //配置默认的数据源
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        //配置目标数据源
        super.setTargetDataSources(targetDataSource);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("determineCurrentLookupKey切换数据源......");
        return DynamicDataSourceContextHolder.getDataSourceType();
    }

}
