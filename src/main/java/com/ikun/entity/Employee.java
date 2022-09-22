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
    private String personId;
    /**
     * 员工手机号
     */
    private String phone;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

