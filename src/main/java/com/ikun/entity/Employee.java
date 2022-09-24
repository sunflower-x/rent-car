package com.ikun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Employee)实体类
 *
 * @author makejava
 * @since 2022-09-22 08:54:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    private static final long serialVersionUID = 402948369930984672L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 员工ID
     */
    private String employeeId;
    /**
     * 员工手机号
     */
    private String phone;
    /**
     * 员工身份证号
     */
    private String cardId;
    /**
     * 员工名字
     */
    private String name;
    /**
     * 员工性别
     */
    private String sex;
    /**
     * 员工邮箱
     */
    private String email;


}

