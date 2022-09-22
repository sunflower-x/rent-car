package com.ikun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Car)实体类
 *
 * @author makejava
 * @since 2022-09-22 08:40:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable {
    private static final long serialVersionUID = 140131703783358543L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 车型号
     */
    private String type;
    /**
     * 销售员ID
     */
    private String empId;
    /**
     * 车牌号
     */
    private String licenseNumber;
    /**
     * 日租金
     */
    private String rent;
    /**
     * 车主身份证号
     */
    private String masterCard;
    /**
     * 车辆出租情况 0未出租 1已出租
     */
    private String carCondition;

}

