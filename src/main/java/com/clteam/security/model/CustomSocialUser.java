package com.clteam.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.security.SocialUser;

import java.util.Collection;

/**
 * Created by Khanh Nguyen on 19/5/2017.
 */
public class CustomSocialUser extends SocialUser {

    private String name;

    public CustomSocialUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String name) {
        super(username, password, authorities);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
