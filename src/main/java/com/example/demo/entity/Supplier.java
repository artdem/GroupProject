package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {

    String supplierName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierID;
    private Long purchaserID;
    private  String purchaserName;

    public String getSupplierName() {
        return supplierName;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }

    public Long getPurchaserID() {
        return purchaserID;
    }

    public void setPurchaserID(Long purchaserID) {
        this.purchaserID = purchaserID;
    }

    @Override
    public String toString() {
        return "supplierName='" + supplierName + '\'' +
                ", supplierID='" + supplierID + '\'' +
                ", purchaserID='" + purchaserID + '\'';
    }
}
