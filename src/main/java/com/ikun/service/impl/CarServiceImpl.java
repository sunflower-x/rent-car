package com.ikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ikun.entity.Car;
import com.ikun.dao.CarDao;
import com.ikun.entity.vo.Constant;
import com.ikun.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Car)表服务实现类
 *
 * @author makejava
 * @since 2022-09-22 08:41:00
 */
@Service("carService")
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public List selectCarList(Integer pageNum,Integer pageSize,String type) {
        QueryWrapper<Car> qw = new QueryWrapper<>();
        qw.gt("id",0);
        qw.like("type","%"+type+"%");
        IPage<Car> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<Car> iPage = carDao.selectPage(page, qw);
        List<Car> records = iPage.getRecords();
        System.out.println("页数："+iPage.getPages());
        System.out.println("总记录条数："+iPage.getTotal());
        System.out.println("当前页码："+iPage.getCurrent());
        System.out.println("每页的记录数："+iPage.getSize());
        return records;
    }

    @Override
    public Constant insertCar(Car car) {
        Constant constant = new Constant();
        Map<String,Object> map = new HashMap<>();
        map.put("license_number",car.getLicenseNumber());
        List<Car> cars = carDao.selectByMap(map);
        if (cars.size()!=0){
            constant.setMsg("该车牌已存在。");
            constant.setCode("500");
            return constant;
        }
        int result = carDao.insert(car);
        if (result==0){
            constant.setCode("404");
            constant.setMsg("插入失败");
            return constant;
        }
        constant.setCode("200");
        constant.setMsg("插入成功");
        return constant;
    }

    @Override
    public int deleteCarById(Integer id) {
        int result = carDao.deleteById(id);
        return result;
    }

    @Override
    public int updateCar(Car car) {
        int result = carDao.updateById(car);
        return result;
    }

    @Override
    public List selectCarListNoPage() {
        QueryWrapper<Car> qw = new QueryWrapper<>();
        qw.gt("id",0);
        List<Car> cars = carDao.selectList(qw);
        return cars;
    }

    @Override
    public List selectClientNotRent(String id) {
        QueryWrapper<Car> qw = new QueryWrapper<>();
        qw.eq("master_card",id);
        qw.eq("car_condition","0");
        List<Car> cars = carDao.selectList(qw);
        return cars;
    }

    @Override
    public List likeSelectCar(String type) {
        QueryWrapper<Car> qw = new QueryWrapper<>();
        qw.like("type","%"+type+"%");
        List<Car> cars = carDao.selectList(qw);
        return cars;
    }


}
