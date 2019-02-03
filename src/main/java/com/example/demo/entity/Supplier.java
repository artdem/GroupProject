package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {

    String supplierName;
    @Id
    private String supplierID;
    private String purchaserName;
    private int purchaserSkypeID;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public int getPurchaserSkypeID() {
        return purchaserSkypeID;
    }

    public void setPurchaserSkypeID(int purchaserSkypeID) {
        this.purchaserSkypeID = purchaserSkypeID;
    }
}
