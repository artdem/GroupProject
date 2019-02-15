package com.example.demo.models;

public enum LackStatus {
    NEW("NEW"),
    ORDERED("ORDERED");
    public String status;

    LackStatus(String status){
        this.status = status;
    }
}

