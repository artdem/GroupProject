package com.example.demo.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ForwarderDTO {

    @NotBlank(message = "Forwarder name must not be null and can't consist of only white characters")
    private String forwarderName;
    @NotBlank(message = "Forwarder ID must not be null and can't consist of only white characters")
    private String forwarderID;
    @Email(message = "Enter valid email")
    private String login;
    @NotBlank(message = "Password must not be null and can't consist of only white characters")
    @Size(min = 6, message = "The minimum password size is 6 characters")
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

    public String getForwarderID() {
        return forwarderID;
    }

    public void setForwarderID(String forwarderID) {
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
