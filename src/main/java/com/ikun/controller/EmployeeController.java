package com.ikun.controller;

import com.ikun.entity.Employee;
import com.ikun.entity.vo.Constant;
import com.ikun.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employee)表控制层
 *
 * @author makejava
 * @since 2022-09-22 08:54:16
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询全部员工信息
     * url:employee/selectall
     * @return
     */
    @GetMapping("/selectall")
    public Constant selectEmpList(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "3") Integer pageSize,@RequestParam(defaultValue = "") String employeeId){
        List<Employee> list = employeeService.selectEmpList(pageNum,pageSize,employeeId);
        Constant constant = new Constant();
        constant.setCode("200");
        constant.setMsg("查询成功。");
        constant.setObj(list);
        return constant;
    }

    /**
     * 根据员工编号查员工信息
     * url:employee/selectbyid
     * @param employeeId
     * @return
     */
    @GetMapping("/selectbyid")
    public Constant selectEmpById(@RequestParam String employeeId){
        List list = employeeService.selectEmpById(employeeId);
        Constant constant = new Constant();
        if (list.isEmpty()){
            constant.setCode("200");
            constant.setMsg("查询成功。");
            return constant;
        }
        constant.setCode("200");
        constant.setMsg("查询成功。");
        constant.setObj(list.get(0));
        return constant;
    }

    /**
     * 插入员工共信息
     * employee/insert
     * @param employee
     * @return
     */
    @PostMapping("/insert")
    public Constant insertEmp(@RequestBody Employee employee) {
        Constant constant = new Constant();
        int result = employeeService.insertEmp(employee);
        if (result==0){
            constant.setCode("404");
            constant.setMsg("插入失败。");
            return constant;
        }
        constant.setCode("200");
        constant.setMsg("插入成功。");
        return constant;
    }

    /**
     * 根据主键删除员工共信息
     * employee/delete
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Constant deleteEmp(@RequestParam Integer id){
        Constant constant = new Constant();
        int result = employeeService.deleteEmp(id);
        if (result==0){
            constant.setCode("404");
            constant.setMsg("删除失败。");
            return constant;
        }
        constant.setCode("200");
        constant.setMsg("删除成功。");
        return constant;
    }

    /**
     * 根据主键更新员工信息
     * employee/update
     * @param employee
     * @return
     */
    @PostMapping("/update")
    public Constant updateEmp(@RequestBody Employee employee){
        Constant constant = new Constant();
        int result = employeeService.updateEmp(employee);
        if (result==0){
            constant.setCode("404");
            constant.setMsg("更新失败。");
            return constant;
        }
        constant.setCode("200");
        constant.setMsg("更新成功。");
        return constant;
    }

}

