package com.ikun.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ikun.dao.InspectBillDao;
import com.ikun.entity.InspectBill;
import com.ikun.entity.RentBill;
import com.ikun.entity.vo.Constant;
import com.ikun.service.InspectBillService;
import com.ikun.util.setSizeColumn;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * (InspectBill)表控制层
 *
 * @author makejava
 * @since 2022-09-22 08:54:56
 */
@RestController
@RequestMapping("inspectBill")
public class InspectBillController {
@Autowired
    InspectBillDao inspectBillDao;
    /**检查单信息增加control
     url:inspectBill/save
     param: inspectBill对象
     **/
    @PostMapping("/save")
    public Constant save(@RequestBody InspectBill inspectBill){
        Constant constant;
        QueryWrapper<InspectBill> wrapper=new QueryWrapper();
        wrapper.eq("id",inspectBill.getId());
        if(inspectBillDao.selectOne(wrapper)!=null){constant=new Constant("ikun","客户已存在",null);}
        else {inspectBillDao.insert(inspectBill);constant=new Constant("200","添加客户信息成功",inspectBill);}
        return constant;
    }
    /**检查单信息修改control
     url:inspectBill/update
     param:  inspectBill  对象
     **/
@PatchMapping("/update")
    public Constant update(@RequestBody InspectBill inspectBill){
       Constant constant;
       inspectBillDao.updateById(inspectBill);
       constant=new Constant("200","修改成功",inspectBill);
        return  constant;
}
    /**检查单信息excel导出control
     url:inspectBill/excel
     param:
     **/
    @GetMapping("/excel")
    public Constant excel(){
        Constant constant;
        QueryWrapper<InspectBill> queryWrapper=new QueryWrapper<>();
        queryWrapper.gt("id",0);
        List list= CollUtil.newArrayList(inspectBillDao.selectList(queryWrapper));
        File file=new File("d:/inspectExcel.xls");
        if(file.exists()){file.delete();}
        ExcelWriter writer= ExcelUtil.getWriter("d:/inspectExcel.xls");
        //跳过当前行
        writer.passCurrentRow();
//一次性写出内容，强制输出标题
        writer.write(list, true);
        setSizeColumn.setSizeColumn(writer.getSheet(),8);
//关闭writer，释放内存
        writer.close();
        constant=new Constant("200","导出成功","d:/inspectExcel.xls");
        return constant;
    }
}

