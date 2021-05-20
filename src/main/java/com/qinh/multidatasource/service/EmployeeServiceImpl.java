package com.qinh.multidatasource.service;

import com.qinh.multidatasource.dao.EmployeeMapper;
import com.qinh.multidatasource.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-05-18-0:45
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public Employee getEmployee(Integer id){
        Employee employee = mapper.getEmpById(id);
        return employee;
    }
}
