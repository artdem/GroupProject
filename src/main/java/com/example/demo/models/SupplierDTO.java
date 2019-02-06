package com.example.demo.models;

import javax.validation.constraints.NotBlank;

public class SupplierDTO {

    @NotBlank(message = "Supplier name must not be null and can't consist of only white characters")
    private String supplierName;
    @NotBlank(message = "Supplier ID must not be null and can't consist of only white characters")
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
