package com.dolap.backend.ecommercesite.application.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.http.HttpMethod.*;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring()
                .antMatchers(GET, "/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**")
                .antMatchers("/h2-console/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(POST, "/seller").permitAll()
                .antMatchers(GET, "/seller/**").permitAll()
                .antMatchers(POST, "/product").permitAll()
                .antMatchers(PUT, "/product/**").permitAll()
                .antMatchers(DELETE, "/product/**").permitAll()
                .antMatchers(GET, "/product/**").permitAll()
                .anyRequest().authenticated();

        http.csrf().disable();
    }

}
