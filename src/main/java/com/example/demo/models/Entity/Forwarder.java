package com.example.demo.models.Entity;

import com.example.demo.models.Role;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Forwarder {

    private String forwarderName;
    @Id
    private long forwarderID;
    private String login;
    private String password;
    private Role role;
    private int SkypeID;
    private boolean logINstatus;

    public String getForwarderName() {
        return forwarderName;
    }

    public void setForwarderName(String forwarderName) {
        this.forwarderName = forwarderName;
    }

    public long getForwarderID() {
        return forwarderID;
    }

    public void setForwarderID(long forwarderID) {
        this.forwarderID = forwarderID;
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

    public int getSkypeID() {
        return SkypeID;
    }

    public void setSkypeID(int skypeID) {
        SkypeID = skypeID;
    }

    public boolean isLogINstatus() {
        return logINstatus;
    }

    public void setLogINstatus(boolean logINstatus) {
        this.logINstatus = logINstatus;
    }
}
