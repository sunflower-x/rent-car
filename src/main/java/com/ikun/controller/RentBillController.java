package com.ikun.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ikun.dao.RentBillDao;
import com.ikun.entity.Customer;
import com.ikun.entity.RentBill;
import com.ikun.entity.vo.Constant;
import com.ikun.service.RentBillService;
import com.ikun.util.setSizeColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * (RentBill)表控制层
 *
 * @author makejava
 * @since 2022-09-22 08:56:09
 */
@RestController
@RequestMapping("rentBill")
public class RentBillController {
@Autowired
    RentBillDao rentBillDao;
    /**出租单信息增加control
     url:rentBill/save
     param:  rentBill对象
     **/
@PostMapping("/save")
    public Constant save(@RequestBody RentBill rentBill){
    Constant constant;
    QueryWrapper<RentBill> wrapper=new QueryWrapper();
    wrapper.eq("id",rentBill.getId());
    if(rentBillDao.selectOne(wrapper)!=null){constant=new Constant("500","客户已存在",null);}
    else {rentBillDao.insert(rentBill);constant=new Constant("200","添加客户信息成功",rentBill);}
    return constant;
}
    /**出租单获取全部信息列表control
     url:rentBill/getall
     param:
     **/
    @GetMapping("/getall")
    public Constant getall(){
        Constant constant;
        QueryWrapper<RentBill> queryWrapper=new QueryWrapper<>();
        queryWrapper.gt("id",0);
        constant=new Constant("200","返回成功",rentBillDao.selectList(queryWrapper));
        return constant;
    }
    /**出租单信息查询control
     url:rentBill/select
     param:  id   查询id
     **/
    @GetMapping("/select")
    public Constant select(@RequestParam Integer id){
        Constant constant;
        RentBill rentBill= rentBillDao.selectById(id);
        constant=new Constant("200","返回成功",rentBill);
        return constant;
    }
    /**出租单信息删除control
     url:rentBill/delete
     param:  删除id
     **/
    @DeleteMapping("/delete")
    public Constant delete(@RequestParam Integer id){
        Constant constant;
        QueryWrapper<RentBill> wrapper=new QueryWrapper();
        wrapper.eq("id",id);
        if(rentBillDao.selectOne(wrapper)==null){constant=new Constant("500","客户不存在",null);}
        else {RentBill rentBill=rentBillDao.selectOne(wrapper);rentBillDao.delete(wrapper);constant=new Constant("200","删除成功",rentBill);}
        return constant;
    }
    /**出租单信息修改control
     url:rentBill/update
     param:  rentBill对象
     **/
    @PatchMapping("/update")
    public Constant update(@RequestBody RentBill rentBill)
    {
        Constant constant;
        rentBillDao.updateById(rentBill);
        constant=new Constant("200","更新成功!!!",rentBill);
        return constant;
    }
    /**分页和模糊control
     url:rentBill/page
     param:  pageNum  页码   pageSize  每页信息数量     search 模糊查询关键字符串
     **/
    @GetMapping("/page")
    public Constant findpage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "") String search){
        Constant constant;
        Page<RentBill> page=rentBillDao.selectPage(new Page<>(pageNum,pageSize), Wrappers.<RentBill>lambdaQuery().like(RentBill::getCustName,search));//like(Customer::getName(根据姓名查找，可修改),search)
        List<RentBill> list=page.getRecords();
        if(list.isEmpty()){constant=new Constant("500","查找失败",null);}
        else{ constant=new Constant("200","查找成功",list);}
        return constant ;
    }
    /**出租单信息excel导出control
     url:rentBill/excel
     param:
     **/
    @GetMapping("/excel")
    public Constant excel(){
        Constant constant;
        QueryWrapper<RentBill> queryWrapper=new QueryWrapper<>();
        queryWrapper.gt("id",0);
        List list= CollUtil.newArrayList(rentBillDao.selectList(queryWrapper));
        File file=new File("d:/billExcel.xls");
        if(file.exists()){file.delete();}
        ExcelWriter writer= ExcelUtil.getWriter("d:/billExcel.xls");
        //跳过当前行
        writer.passCurrentRow();
//一次性写出内容，强制输出标题
        writer.write(list, true);
        setSizeColumn.setSizeColumn(writer.getSheet(),9);

//关闭writer，释放内存
        writer.close();

        constant=new Constant("200","导出成功","d:/billExcel.xls");
        return constant;
    }
}

