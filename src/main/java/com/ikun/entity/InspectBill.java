package com.ikun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (InspectBill)实体类
 *
 * @author makejava
 * @since 2022-09-22 08:54:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectBill implements Serializable {
    private static final long serialVersionUID = -42471617757081036L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 客户姓名
     */
    private String custName;
    /**
     * 客户身份证号
     */
    private String custCard;
    /**
     * 车牌号
     */
    private String licenseNumber;
    /**
     * 办理业务员ID
     */
    private String personId;
    /**
     * 超出换车天数
     */
    private String overTime;
    /**
     * 租车时汽车照片
     */
    private String carStart;
    /**
     * 换车时汽车照片
     */
    private String carEnd;
    /**
     * 赔款金额
     */
    private String indemnity;


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

    public String getlicenseNumber() {
        return  licenseNumber;
    }

    public void setlicenseNumber(String  licenseNumber) {
        this. licenseNumber =  licenseNumber;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String getCarStart() {
        return carStart;
    }

    public void setCarStart(String carStart) {
        this.carStart = carStart;
    }

    public String getCarEnd() {
        return carEnd;
    }

    public void setCarEnd(String carEnd) {
        this.carEnd = carEnd;
    }

    public String getIndemnity() {
        return indemnity;
    }

    public void setIndemnity(String indemnity) {
        this.indemnity = indemnity;
    }

}

