package com.clteam.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

/**
 * Created by Khanh Nguyen on 19/5/2017.
 */
public class CustomUser extends User {

    private String name;
    private byte state;

    public CustomUser(String username, String password, Set<GrantedAuthority> grantedAuthorities, String name, byte state) {
        super(username, password, grantedAuthorities);
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }
}
