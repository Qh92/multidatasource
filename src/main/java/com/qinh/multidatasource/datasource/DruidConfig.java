package com.qinh.multidatasource.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-05-18-1:10
 */
@Slf4j
@Configuration
public class DruidConfig {

    //加载主数据源配置
    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDataSource(){

        return DruidDataSourceBuilder.create().build();
    }

    //加载从数据库配置
    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    public DataSource slaveDataSource(){

        DruidDataSource build = DruidDataSourceBuilder.create().build();
        return build;
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dataSource(){
        Map<Object,Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.MASTER.name(),masterDataSource());
        targetDataSources.put(DataSourceType.SLAVE.name(),slaveDataSource());
        return new DynamicDataSource(masterDataSource(),targetDataSources);
    }

}
