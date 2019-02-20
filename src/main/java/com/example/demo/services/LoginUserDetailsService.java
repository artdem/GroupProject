package com.example.demo.services;

import com.example.demo.models.LoginUser;
import com.example.demo.models.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDTO user = repository.findByLogin(login);

        return new LoginUser(user, getAuthorities(user.getRole()));
    }

    public List<GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority(role));

        return list;
    }
}
