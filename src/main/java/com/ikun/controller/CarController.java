package com.ikun.controller;

import com.ikun.entity.Car;
import com.ikun.entity.vo.Constant;
import com.ikun.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @GetMapping("/select")
    public Constant selectCarList(){
        Constant constant = new Constant();
        List cars = carService.selectCarList();
        constant.setMsg("查询成功！");
        constant.setCode("200");
        constant.setObj(cars);
        return constant;
    }

    @PostMapping("/insert")
    public Constant insertCar(@RequestBody Car car){
        return carService.insertCar(car);
    }

    @GetMapping("/delete")
    public Constant deleteCar(@RequestParam Integer id){
        Constant constant = new Constant();
        int result = carService.deleteCarById(id);
        if (result==0){
            constant.setCode("404");
            constant.setMsg("删除失败。");
            return constant;
        }
        constant.setCode("200");
        constant.setMsg("删除成功。");
        return constant;
    }

    @PostMapping("/update")
    public Constant updateCar(@RequestBody Car car){
        Constant constant = new Constant();
        int result = carService.updateCar(car);
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

