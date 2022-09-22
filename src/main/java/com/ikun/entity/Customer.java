package com.ikun.entity;

import java.io.Serializable;

/**
 * (Customer)实体类
 *
 * @author makejava
 * @since 2022-09-22 08:47:42
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = -37107586764144762L;
    
    private Integer id;
    /**
     * 客户姓名
     */
    private String name;
    
    private String phone;
    
    private String cardId;
    
    private String gender;
    
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

