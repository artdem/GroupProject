package com.example.demo.models;

import java.time.LocalDate;

public class LackDTO {

    private String item;
    private int requiredAmount;
    private String forwarderAdditionalComment;
    private String forwarderID;
    private String purchaserID;
    private String supplierID;
    private LocalDate LacksSetDateAndTime;
    private LackStatus status;
    private String lackID;
    private int orderedAmount;
    private LocalDate expectedDeliveryDateAndTime;
    private String purchaserAdditionalComment;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public String getForwarderAdditionalComment() {
        return forwarderAdditionalComment;
    }

    public void setForwarderAdditionalComment(String forwarderAdditionalComment) {
        this.forwarderAdditionalComment = forwarderAdditionalComment;
    }

    public String getForwarderID() {
        return forwarderID;
    }

    public void setForwarderID(String forwarderID) {
        this.forwarderID = forwarderID;
    }

    public String getPurchaserID() {
        return purchaserID;
    }

    public void setPurchaserID(String purchaserID) {
        this.purchaserID = purchaserID;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public LocalDate getLacksSetDateAndTime() {
        return LacksSetDateAndTime;
    }

    public void setLacksSetDateAndTime(LocalDate lacksSetDateAndTime) {
        LacksSetDateAndTime = lacksSetDateAndTime;
    }

    public LackStatus getStatus() {
        return status;
    }

    public void setStatus(LackStatus status) {
        this.status = status;
    }

    public String getLackID() {
        return lackID;
    }

    public void setLackID(String lackID) {
        this.lackID = lackID;
    }

    public int getOrderedAmount() {
        return orderedAmount;
    }

    public void setOrderedAmount(int orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    public LocalDate getExpectedDeliveryDateAndTime() {
        return expectedDeliveryDateAndTime;
    }

    public void setExpectedDeliveryDateAndTime(LocalDate expectedDeliveryDateAndTime) {
        this.expectedDeliveryDateAndTime = expectedDeliveryDateAndTime;
    }

    public String getPurchaserAdditionalComment() {
        return purchaserAdditionalComment;
    }

    public void setPurchaserAdditionalComment(String purchaserAdditionalComment) {
        this.purchaserAdditionalComment = purchaserAdditionalComment;
    }

    @Override
    public String toString() {
        return "LackDTO{" +
                "item='" + item + '\'' +
                ", requiredAmount=" + requiredAmount +
                ", forwarderAdditionalComment='" + forwarderAdditionalComment + '\'' +
                ", forwarderID='" + forwarderID + '\'' +
                ", purchaserID='" + purchaserID + '\'' +
                ", supplierID='" + supplierID + '\'' +
                ", LacksSetDateAndTime=" + LacksSetDateAndTime +
                ", status=" + status +
                ", lackID='" + lackID + '\'' +
                ", orderedAmount=" + orderedAmount +
                ", expectedDeliveryDateAndTime=" + expectedDeliveryDateAndTime +
                ", purchaserAdditionalComment='" + purchaserAdditionalComment + '\'' +
                '}';
    }
}
