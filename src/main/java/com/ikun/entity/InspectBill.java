package com.ikun.entity;

import java.io.Serializable;

/**
 * (InspectBill)实体类
 *
 * @author makejava
 * @since 2022-09-22 08:54:56
 */
public class InspectBill implements Serializable {
    private static final long serialVersionUID = -42471617757081036L;
    
    private Integer id;
    
    private String custName;
    
    private String custCard;
    
    private String  licenseNumber;
    
    private String personId;
    
    private String overTime;
    
    private String carStart;
    
    private String carEnd;
    
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

