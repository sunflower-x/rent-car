package com.ikun.service;

import com.ikun.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Employee)表服务接口
 *
 * @author makejava
 * @since 2022-09-22 08:54:16
 */
public interface EmployeeService {

    /**
     * 查询员工列表
     * @return
     */
    List selectEmpList(Integer pageNum,Integer pageSize,String employeeId);

    List selectEmpById(String employeeId);

    int insertEmp(Employee employee);

    int deleteEmp(Integer id);

    int updateEmp(Employee employee);


}
