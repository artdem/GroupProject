package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {

    String supplierName;
    @Id
    private String supplierID;
    private String purchaserID;


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

    public String getPurchaserID() {
        return purchaserID;
    }

    public void setPurchaserID(String purchaserID) {
        this.purchaserID = purchaserID;
    }

    @Override
    public String toString() {
        return "supplierName='" + supplierName + '\'' +
                ", supplierID='" + supplierID + '\'' +
                ", purchaserID='" + purchaserID + '\'';
    }
}
