package com.example.demo.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalDate;

public class LackDTO {

    @NotBlank(message = "Item name must not be null and can't consist of only white characters")
    private String item;
    @Min(value = 1, message = "Minimal value is 1")
    private int requiredAmount;
    private String forwarderAdditionalComment;
    private String forwarderID;
    private String purchaserID;
    private String supplierID;
    private LocalDate lacksSetDateAndTime;
    private LackStatus status;
    private String lackID;
    private int orderedAmount;
    private Date expectedDeliveryDateAndTime;
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
        return lacksSetDateAndTime;
    }

    public void setLacksSetDateAndTime(LocalDate lacksSetDateAndTime) {
        this.lacksSetDateAndTime = lacksSetDateAndTime;
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

    public Date getExpectedDeliveryDateAndTime() {
        return expectedDeliveryDateAndTime;
    }

    public void setExpectedDeliveryDateAndTime(Date expectedDeliveryDateAndTime) {
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
                ", lacksSetDateAndTime=" + lacksSetDateAndTime +
                ", status=" + status +
                ", lackID='" + lackID + '\'' +
                ", orderedAmount=" + orderedAmount +
                ", expectedDeliveryDateAndTime=" + expectedDeliveryDateAndTime +
                ", purchaserAdditionalComment='" + purchaserAdditionalComment + '\'' +
                '}';
    }
}
