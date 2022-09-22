package com.ikun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (RentBill)实体类
 *
 * @author makejava
 * @since 2022-09-22 08:56:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentBill implements Serializable {
    private static final long serialVersionUID = 533687706034718019L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String custName;

    private String custCard;

    private String licenseNumber;

    private String personId;

    private Date createTime;

    private Date deleteTime;

    private String tenancy;

    private String lumpSum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustCard() {
        return custCard;
    }

    public void setCustCard(String custCard) {
        this.custCard = custCard;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getTenancy() {
        return tenancy;
    }

    public void setTenancy(String tenancy) {
        this.tenancy = tenancy;
    }

    public String getLumpSum() {
        return lumpSum;
    }

    public void setLumpSum(String lumpSum) {
        this.lumpSum = lumpSum;
    }

}

