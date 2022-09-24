package com.ikun.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.ikun.entity.Car;
import com.ikun.entity.vo.Constant;
import com.ikun.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * (Car)表控制层
 *
 * @author makejava
 * @since 2022-09-22 08:40:57
 */
@RestController
@RequestMapping("car")
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * 查询全部车辆信息
     * url:car/select
     * @return
     */
    @GetMapping("/select")
    public Constant selectCarList() {
        Constant constant = new Constant();
        List<Car> cars = carService.selectCarList();
        for (Car car : cars) {
            car.setCarCondition("0".equals(car.getCarCondition())?"未出租":"已出租");
        }
        constant.setMsg("查询成功！");
        constant.setCode("200");
        constant.setObj(cars);
        return constant;
    }

    /**
     * 插入车辆信息
     * url:car/insert
     * @param car
     * @return
     */
    @PostMapping("/insert")
    public Constant insertCar(@RequestBody Car car) {
        return carService.insertCar(car);
    }

    /**
     * 根据主键删除车辆信息
     * url:car/delete
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Constant deleteCar(@RequestParam Integer id) {
        Constant constant = new Constant();
        int result = carService.deleteCarById(id);
        if (result == 0) {
            constant.setCode("404");
            constant.setMsg("删除失败。");
            return constant;
        }
        constant.setCode("200");
        constant.setMsg("删除成功。");
        return constant;
    }

    /**
     * 根据主键删除车辆信息
     * url:car/update
     * @param car
     * @return
     */
    @PostMapping("/update")
    public Constant updateCar(@RequestBody Car car) {
        Constant constant = new Constant();
        int result = carService.updateCar(car);
        if (result == 0) {
            constant.setCode("404");
            constant.setMsg("更新失败。");
            return constant;
        }
        constant.setCode("200");
        constant.setMsg("更新成功。");
        return constant;
    }

    /**
     * 导出车辆信息到excel
     * url:car/download
     * @param response
     * @return
     */
    @GetMapping("/download")
    public Constant download(HttpServletResponse response) {
        Constant constant = new Constant();
        List<Car> list = carService.selectCarListNoPage();
        for (Car car : list) {
            car.setCarCondition("0".equals(car.getCarCondition())?"未出租":"已出租");
        }
        ExcelWriter writer = null;
        ServletOutputStream out = null;
        try {
            // 通过工具类创建writer，默认创建xls格式
            writer = ExcelUtil.getWriter();
            //给字段别名
            writer.addHeaderAlias("type", "车型号");
            writer.addHeaderAlias("empId", "销售员ID");
            writer.addHeaderAlias("licenseNumber", "车牌号");
            writer.addHeaderAlias("rent", "日租金");
            writer.addHeaderAlias("masterCard", "车主身份证号");
            writer.addHeaderAlias("carCondition", "车辆出租情况");
            // 默认的，未添加alias的属性也会写出，如果想只写出加了别名的字段，可以调用此方法排除之
            writer.setOnlyAlias(true);
            // 一次性写出内容，使用默认样式，强制输出标题
            writer.write(list, true);
            //out为OutputStream，需要写出到的目标流
            //response为HttpServletResponse对象
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
            response.setHeader("Content-Disposition", "attachment;filename=car.xls");
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            constant.setCode("200");
            constant.setMsg("下载成功");
            writer.flush(out, true);
            // 关闭writer，释放内存
            writer.close();
            //此处记得关闭输出Servlet流
            IoUtil.close(out);
        }
        return null;
    }

    /**
     * 查询未出租车辆信息
     * url:car/norent
     * @param id
     * @return
     */
    @PostMapping("/norent")
    public Constant selectClientNotRent(@RequestParam String id){
        List<Car> list = carService.selectClientNotRent(id);
        for (Car car : list) {
            car.setCarCondition("0".equals(car.getCarCondition())?"未出租":"已出租");
        }
        Constant constant = new Constant();
        constant.setCode("200");
        constant.setMsg("查询成功。");
        constant.setObj(list);
        return constant;
    }

    /**
     * 根据车类型模糊查询
     * url:car/like
     * @param type
     * @return
     */
    @GetMapping("/like")
    public Constant likeSelectCar(@RequestParam String type){
        List<Car> list = carService.likeSelectCar(type);
        for (Car car : list) {
            car.setCarCondition("0".equals(car.getCarCondition())?"未出租":"已出租");
        }
        Constant constant = new Constant();
        constant.setCode("200");
        constant.setMsg("查询成功");
        constant.setObj(list);
        return constant;
    }
}

