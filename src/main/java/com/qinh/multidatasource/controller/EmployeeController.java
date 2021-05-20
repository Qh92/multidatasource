package com.qinh.multidatasource.controller;

import com.qinh.multidatasource.datasource.DataSourceAnnotation;
import com.qinh.multidatasource.datasource.DataSourceType;
import com.qinh.multidatasource.entity.Employee;
import com.qinh.multidatasource.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-05-18-0:36
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    //不指定数据源，默认查询方法
    @GetMapping("/default/{id}")
    public Employee defaultDataSource(@PathVariable Integer id){
        return service.getEmployee(id);
    }

    //使用自定义注解，数据源为master
    @GetMapping("/master/{id}")
    @DataSourceAnnotation(DataSourceType.MASTER)
    public Employee master(@PathVariable Integer id){
        return service.getEmployee(id);
    }

    //数据源为slave
    @RequestMapping("/slave/{id}")
    @DataSourceAnnotation(DataSourceType.SLAVE)
    public Employee slave(@PathVariable Integer id){
        return service.getEmployee(id);
    }




}
