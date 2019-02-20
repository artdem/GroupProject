package com.example.demo.models;

import javax.validation.constraints.NotBlank;

public class SupplierDTO {

    @NotBlank(message = "Supplier name must not be null and can't consist of only white characters")
    private String supplierName;
    private Long supplierID;
    private Long purchaserID;
    private String purchaserName;

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public String getSupplierName() {
        return supplierName;
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
        return "SupplierDTO{" +
                "supplierName='" + supplierName + '\'' +
                ", purchaserID=" + purchaserID +
                ", purchaserName='" + purchaserName + '\'' +
                '}';
    }
}
