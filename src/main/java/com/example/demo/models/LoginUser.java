package com.example.demo.models;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class LoginUser extends User {

    public LoginUser(UserDTO user, List<GrantedAuthority> grantedAuthorityList) {
        super(user.getLogin(), user.getPassword(), grantedAuthorityList);
    }
}
