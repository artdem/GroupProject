package com.example.demo.models;

import java.time.LocalDate;

public class LackDTO {

    private ItemDTO item;
    private int requiredAmount;
    private String unitOfMeasure;
    private String forwarderAdditionalComment;
    private int forwarderID;
    private int forwarderSkypeID;
    private SupplierDTO Supplier;
    private LocalDate LacksSetDateAndTime;
    private Boolean status;
    private int lackID;
    private int orderedAmount;
    private LocalDate expectedDeliveryDateAndTime;
    private String purchaserAdditionalComment;

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getForwarderAdditionalComment() {
        return forwarderAdditionalComment;
    }

    public void setForwarderAdditionalComment(String forwarderAdditionalComment) {
        this.forwarderAdditionalComment = forwarderAdditionalComment;
    }

    public int getForwarderID() {
        return forwarderID;
    }

    public void setForwarderID(int forwarderID) {
        this.forwarderID = forwarderID;
    }

    public int getForwarderSkypeID() {
        return forwarderSkypeID;
    }

    public void setForwarderSkypeID(int forwarderSkypeID) {
        this.forwarderSkypeID = forwarderSkypeID;
    }

    public SupplierDTO getSupplier() {
        return Supplier;
    }

    public void setSupplier(SupplierDTO supplier) {
        Supplier = supplier;
    }

    public LocalDate getLacksSetDateAndTime() {
        return LacksSetDateAndTime;
    }

    public void setLacksSetDateAndTime(LocalDate lacksSetDateAndTime) {
        LacksSetDateAndTime = lacksSetDateAndTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getLackID() {
        return lackID;
    }

    public void setLackID(int lackID) {
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
}
