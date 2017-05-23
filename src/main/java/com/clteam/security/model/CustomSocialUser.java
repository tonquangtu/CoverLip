package com.clteam.security.model;

import com.clteam.dataobject.AccountEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.security.SocialUser;

import java.util.Collection;

/**
 * Created by Khanh Nguyen on 19/5/2017.
 */
public class CustomSocialUser extends SocialUser {

    private AccountEntity accountEntity;
    private String name;
    private int state;

    public CustomSocialUser(String username, String password, Collection<? extends GrantedAuthority> authorities, AccountEntity accountEntity) {
        super(username, password, authorities);
        this.accountEntity = accountEntity;
        this.name = accountEntity.getFullname();
        this.state = accountEntity.getState();
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
