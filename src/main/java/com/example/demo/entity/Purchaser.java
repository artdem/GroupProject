package com.example.demo.entity;

import com.example.demo.models.Role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchaser {

    private String purchaserName;
    @Id
    private String purchaserID;
    private String login;
    private String password;
    private Role role;
    private String phoneNumber;
    private boolean logINstatus;

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public String getPurchaserID() {
        return purchaserID;
    }

    public void setPurchaserID(String purchaserID) {
        this.purchaserID = purchaserID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isLogINstatus() {
        return logINstatus;
    }

    public void setLogINstatus(boolean logINstatus) {
        this.logINstatus = logINstatus;
    }
}
