package com.ikun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Customer)实体类
 *
 * @author makejava
 * @since 2022-09-22 08:47:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    private static final long serialVersionUID = -37107586764144762L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 客户姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 身份证号
     */
    private String cardId;
    /**
     * 客户性别
     */
    private String gender;
    /**
     * 汽车数量
     */
    private Integer carNumber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

}

