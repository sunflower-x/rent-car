package com.ikun.controller;



import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ikun.dao.CustomerDao;
import com.ikun.entity.Customer;
import com.ikun.entity.vo.Constant;
import com.ikun.entity.vo.CustVo;
import com.ikun.service.CustomerService;
import com.ikun.entity.Customer;
import com.ikun.service.CustomerService;
import com.ikun.util.setSizeColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
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
/**客户增加control
url:customer/save
 param: customer对象
 **/
  @PostMapping("/save")
    public Constant save(@RequestBody Customer customer){
      Constant constant;
      QueryWrapper<Customer> wrapper=new QueryWrapper();
      wrapper.eq("card_id",customer.getCardId());

     if(customerDao.selectOne(wrapper)!=null){constant=new Constant("500","客户已存在",null);}
     else {customerDao.insert(customer);constant=new Constant("200","添加客户信息成功",customer);}
      return  constant;
  }
    /**返回全部客户信息control
     url:customer/getall
     param:
     **/
  @GetMapping("/getall")
    public Constant get(){
      Constant constant;
      QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
      queryWrapper.gt("id",0);
      constant=new Constant("200","返回成功",customerDao.selectList(queryWrapper));
      return constant;
  }
    /**客户信息删除control
     url:customer/delete
     param: id   删除的客户信息的id
     **/
@DeleteMapping("/delete")
    public Constant delete(@RequestParam Integer id){
    Constant constant;
    QueryWrapper<Customer> wrapper=new QueryWrapper();
    wrapper.eq("id",id);
    if(customerDao.selectOne(wrapper)==null){constant=new Constant("500","客户不存在",null);}
    else {Customer customer=customerDao.selectOne(wrapper);customerDao.delete(wrapper);constant=new Constant("200","删除成功",customer);}
      return constant;
}
    /**客户信息修改control
     url:customer/update
     param: customer   对象
     **/
@PatchMapping("/update")
public Constant update(@RequestBody Customer customer)
{
    Constant constant;
    customerDao.updateById(customer);
    constant=new Constant("200","更新成功!!!",customer);
    return constant;
}
    /**分页和模糊查询control
     url:customer/page
     param: pageNum  页码   pageSize  每页信息数量     search 模糊查询关键字符串
     **/
    @GetMapping("/page")
    public Constant findpage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody CustVo custVo){
        Constant constant;
        Page<Customer> page=customerDao.selectPage(new Page<>(pageNum,pageSize), Wrappers.<Customer>lambdaQuery().like(Customer::getName,custVo.getName())
                .like(Customer::getCardId,custVo.getCardId()).like(Customer::getPhone,custVo.getPhone()));
       List<Customer> list=page.getRecords();
       if(list.isEmpty()){constant=new Constant("500","查找失败",null);}
       else{ constant=new Constant("200","查找成功",list);}
        return constant ;
    }
    /**客户信息excel导出 control
     url:customer/excel
     param:
     **/
    @GetMapping("/excel")
    public Constant excel(){
      Constant constant;
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        queryWrapper.gt("id",0);
      List list=CollUtil.newArrayList(customerDao.selectList(queryWrapper));
     File file=new File("d:/rentExcel.xls");
     if(file.exists()){file.delete();}
        ExcelWriter writer= ExcelUtil.getWriter("d:/rentExcel.xls");
        //跳过当前行
        writer.passCurrentRow();
//一次性写出内容，强制输出标题
        writer.write(list, true);
        setSizeColumn.setSizeColumn(writer.getSheet(),4);
//关闭writer，释放内存
        writer.close();

        constant=new Constant("200","导出成功","d:/rentExcel.xls");
      return constant;
    }
}

