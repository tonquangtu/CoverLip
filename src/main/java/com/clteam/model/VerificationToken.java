package com.clteam.model;

import com.clteam.dataobject.AccountEntity;

import java.sql.Timestamp;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
public class VerificationToken {

    private int id;
    private String token;
    private Timestamp expiryDate;
    private int accountId;
    private AccountEntity accountByAccountId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public AccountEntity getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(AccountEntity accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }
}
