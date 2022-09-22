package com.ikun.service.impl;

import com.ikun.entity.Employee;
import com.ikun.dao.EmployeeDao;
import com.ikun.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (Employee)表服务实现类
 *
 * @author makejava
 * @since 2022-09-22 08:54:16
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

}
