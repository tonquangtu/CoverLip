package com.clteam.security.model;

import com.clteam.dataobject.AccountEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

/**
 * Created by Khanh Nguyen on 19/5/2017.
 */
public class CustomUser extends User {

    private AccountEntity accountEntity;
    private String name;
    private int state;

    public CustomUser(String username, String password, Set<GrantedAuthority> grantedAuthorities, AccountEntity accountEntity) {
        super(username, password, grantedAuthorities);
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
