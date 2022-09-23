package com.ikun.service;

import com.ikun.entity.Car;
import com.ikun.entity.vo.Constant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Car)表服务接口
 *
 * @author makejava
 * @since 2022-09-22 08:40:59
 */

public interface CarService {

    /**
     * 查询车辆列表
     * @return
     */
    List selectCarList();

    /**
     * 插入车辆信息
     * @param car
     * @return
     */
    Constant insertCar(Car car);

    /**
     * 根据ID删除车辆信息
     * @param id
     * @return
     */
    int deleteCarById(Integer id);

    /**
     * 根据ID更新车辆信息
     * @param car
     * @return
     */
    int updateCar(Car car);

    /**
     * 查询车辆列表全部，用于导出excel
     * @return
     */
    List selectCarListNoPage();

    /**
     * 根据身份证号查询客户未出租车辆
     * @return
     */
    List selectClientNotRent(String id);

}
