package com.example.demo.models;

import javax.validation.constraints.NotBlank;

public class ItemDTO {

    @NotBlank(message = "Item ID must not be null and can't consist of only white characters")
    private String itemID;
    @NotBlank(message = "Item name must not be null and can't consist of only white characters")
    private String itemName;

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
