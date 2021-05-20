package com.qinh.multidatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.qinh.multidatasource.dao")
public class MultidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultidatasourceApplication.class, args);
    }



}
