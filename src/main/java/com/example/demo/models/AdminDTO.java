package com.example.demo.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AdminDTO {

    @NotBlank(message = "Employee name must not be null and can't consist of only white characters")
    private String employeeName;
    private long employeeID;
    @Email(message = "Enter valid email")
    private String login;
    @NotBlank(message = "Password must not be null and can't consist of only white characters")
    @Size(min = 6, message = "The minimum password size is 6 characters")
    private String password;
    private Role role;
    private int SkypeID;
    private boolean logINstatus;
}
