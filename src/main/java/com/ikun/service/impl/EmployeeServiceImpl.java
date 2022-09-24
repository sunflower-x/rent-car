package com.ikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ikun.entity.Car;
import com.ikun.entity.Employee;
import com.ikun.dao.EmployeeDao;
import com.ikun.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employee)表服务实现类
 *
 * @author makejava
 * @since 2022-09-22 08:54:16
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List selectEmpList() {
        QueryWrapper<Employee> qw = new QueryWrapper<>();
        qw.gt("id",0);
        IPage<Employee> page = new Page<>();
        page.setCurrent(1);
        page.setSize(3);
        IPage<Employee> iPage = employeeDao.selectPage(page,qw);
        List<Employee> records = iPage.getRecords();
        return records;
    }

    @Override
    public List selectEmpById(String employeeId) {
        QueryWrapper<Employee> qw = new QueryWrapper<>();
        qw.eq("employee_id",employeeId);
        List<Employee> employees = employeeDao.selectList(qw);
        return employees;
    }

    @Override
    public int insertEmp(Employee employee) {
        int result = employeeDao.insert(employee);
        return result;
    }

    @Override
    public int deleteEmp(Integer id) {
        int result = employeeDao.deleteById(id);
        return result;
    }

    @Override
    public int updateEmp(Employee employee) {
        int result = employeeDao.updateById(employee);
        return result;
    }
}
