package com.ikun.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ikun.dao.CustomerDao;
import com.ikun.entity.Customer;
import com.ikun.entity.vo.Constant;
import com.ikun.service.CustomerService;
import com.ikun.entity.Customer;
import com.ikun.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Customer)表控制层
 *
 * @author makejava
 * @since 2022-09-22 08:47:41
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
@Autowired
    CustomerService customerService;
@Autowired
    CustomerDao customerDao;
  @PostMapping("/save")
    public Constant save(@RequestBody Customer customer){
      Constant constant;
      QueryWrapper<Customer> wrapper=new QueryWrapper();
      wrapper.eq("card_id",customer.getCardId());

     if(customerDao.selectOne(wrapper)!=null){constant=new Constant("ikun","客户已存在",null);}
     else {customerDao.insert(customer);constant=new Constant("200","添加客户信息成功",customer);};
      return  constant;
  }
  @GetMapping("/getall")
    public Constant get(){
      Constant constant;
      QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
      queryWrapper.gt("id",0);
      constant=new Constant("200","返回成功",customerDao.selectList(queryWrapper));
      return constant;
  }
@DeleteMapping("/delete")
    public Constant delete(@RequestParam Integer id){
    Constant constant;
    QueryWrapper<Customer> wrapper=new QueryWrapper();
    wrapper.eq("id",id);
    if(customerDao.selectOne(wrapper)==null){constant=new Constant("ikun","客户不存在",null);}
    else {Customer customer=customerDao.selectOne(wrapper);customerDao.delete(wrapper);constant=new Constant("200","删除成功",customer);}
      return constant;
}
@PatchMapping("/update")
public Constant update(@RequestBody Customer customer)
{
    Constant constant;
    customerDao.updateById(customer);
    constant=new Constant("200","更新成功!!!",customer);
    return constant;
}
    @GetMapping("/page")
    public Constant findpage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "") String search){
        Constant constant;
        Page<Customer> page=customerDao.selectPage(new Page<>(pageNum,pageSize), Wrappers.<Customer>lambdaQuery().like(Customer::getName,search));//like(Customer::getName(根据姓名查找，可修改),search)
       List<Customer> list=page.getRecords();
       if(list.isEmpty()){constant=new Constant("ikun","查找失败",null);}
       else{ constant=new Constant("200","查找成功",list);}
        return constant ;
    }
}

