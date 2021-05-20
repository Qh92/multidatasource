package com.qinh.multidatasource.dao;


import com.qinh.multidatasource.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-05-05-22:27
 */
@Mapper
public interface EmployeeMapper {
    Employee getEmpById(Integer id);
}
