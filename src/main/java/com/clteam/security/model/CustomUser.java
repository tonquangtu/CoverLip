package com.clteam.security.model;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Khanh Nguyen on 19/5/2017.
 */
public class CustomUser extends User {

    private String name;

    public CustomUser(String username, String password, Set<GrantedAuthority> grantedAuthorities, String name) {
        super(username, password, grantedAuthorities);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
