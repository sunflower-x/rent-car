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

    private String type;

    private String empId;

    private String licenseNumber;

    private String rent;

    private String masterCard;

    private String condition;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getMasterCard() {
        return masterCard;
    }

    public void setMasterCard(String masterCard) {
        this.masterCard = masterCard;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}

