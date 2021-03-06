package com.example.demo.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

public class LackDTO {

    @NotBlank(message = "Item name must not be null and can't consist of only white characters")
    private String item;
    @NotNull(message = "Enter required amount of item")
    private String requiredAmount;
    private String forwarderAdditionalComment;
    private Long forwarderID;
    private String forwarderName;
    private Long purchaserID;
    private String purchaserName;
    private Long supplierID;
    private String supplierName;
    private LocalDate lacksSetDateAndTime;
    private LackStatus status;
    private Long lackID;
    private String orderedAmount;
    private Date expectedDeliveryDateAndTime;
    private String purchaserAdditionalComment;

    public String getForwarderName() {
        return forwarderName;
    }

    public void setForwarderName(String forwarderName) {
        this.forwarderName = forwarderName;
    }

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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(String requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public String getForwarderAdditionalComment() {
        return forwarderAdditionalComment;
    }

    public void setForwarderAdditionalComment(String forwarderAdditionalComment) {
        this.forwarderAdditionalComment = forwarderAdditionalComment;
    }

    public Long getForwarderID() {
        return forwarderID;
    }

    public void setForwarderID(Long forwarderID) {
        this.forwarderID = forwarderID;
    }

    public Long getPurchaserID() {
        return purchaserID;
    }

    public void setPurchaserID(Long purchaserID) {
        this.purchaserID = purchaserID;
    }

    public Long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Long supplierID) {
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

    public Long getLackID() {
        return lackID;
    }

    public void setLackID(Long lackID) {
        this.lackID = lackID;
    }

    public String getOrderedAmount() {
        return orderedAmount;
    }

    public void setOrderedAmount(String orderedAmount) {
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
                ", requiredAmount='" + requiredAmount + '\'' +
                ", forwarderAdditionalComment='" + forwarderAdditionalComment + '\'' +
                ", forwarderName='" + forwarderName + '\'' +
                ", purchaserName='" + purchaserName + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", lacksSetDateAndTime=" + lacksSetDateAndTime +
                ", status=" + status +
                ", lackID=" + lackID +
                ", orderedAmount='" + orderedAmount + '\'' +
                ", expectedDeliveryDateAndTime=" + expectedDeliveryDateAndTime +
                ", purchaserAdditionalComment='" + purchaserAdditionalComment + '\'' +
                '}';
    }
}
