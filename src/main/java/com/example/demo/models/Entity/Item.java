package com.example.demo.models.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    private String itemID;
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
