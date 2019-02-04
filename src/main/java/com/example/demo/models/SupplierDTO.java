package com.example.demo.models;

import javax.validation.constraints.NotBlank;

public class SupplierDTO {

    @NotBlank(message = "Supplier name must not be null and can't consist of only white characters")
    private String supplierName;
    @NotBlank(message = "Supplier name must not be null and can't consist of only white characters")
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

    @Override
    public String toString() {
        return "SupplierDTO{" +
                "supplierName='" + supplierName + '\'' +
                ", supplierID='" + supplierID + '\'' +
                ", purchaserName='" + purchaserName + '\'' +
                ", purchaserSkypeID=" + purchaserSkypeID +
                '}';
    }
}
