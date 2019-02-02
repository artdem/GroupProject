package com.example.demo.models;

public class SupplierDTO {

    private String supplierName;
    private int supplierID;
    private String purchaserName;
    private int purchaserID;
    private int purchaserSkypeID;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public int getPurchaserID() {
        return purchaserID;
    }

    public void setPurchaserID(int purchaserID) {
        this.purchaserID = purchaserID;
    }

    public int getPurchaserSkypeID() {
        return purchaserSkypeID;
    }

    public void setPurchaserSkypeID(int purchaserSkypeID) {
        this.purchaserSkypeID = purchaserSkypeID;
    }
}
