package com.clteam.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by Khanh Nguyen on 7/5/2017.
 * @author Khanh Nguyen
 * SecurityService class provide current logged in user and auto login user after registering account
 * Reference of: https://hellokoding.com/registration-and-login-example-with-spring-xml-configuration-maven-jsp-and-mysql/
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String findLoggedInUserName() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (obj instanceof UserDetails) {
            return ((UserDetails) obj).getUsername();
        }
        return null;
    }

    @Override
    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (usernamePasswordAuthenticationToken.isAuthenticated())  {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }

}

