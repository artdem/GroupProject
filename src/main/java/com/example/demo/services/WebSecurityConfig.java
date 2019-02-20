package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private LoginUserDetailsService userService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

            httpSecurity
                    .authorizeRequests()
                    .antMatchers("/")
                    .permitAll()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/h2-console/**")
                    .permitAll()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/purchaser/**")
                    .hasRole("PURCHASER")
                    .and()
                    .authorizeRequests()
                    .antMatchers("/admin/**")
                    .hasRole("ADMIN")
                    .and()
                    .authorizeRequests()
                    .antMatchers("/forwarder/**")
                    .hasRole("FORWARDER")
                    .and()

                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .permitAll()
                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/accessdenied");

            httpSecurity.csrf().disable();
            httpSecurity.headers().frameOptions().disable();
        }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);

    }
}
