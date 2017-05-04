package com.clteam.model;

import com.clteam.dataobject.AccountEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Dell on 30-Apr-17.
 */
public class Account implements Serializable {

    public static final int ADMIN = 2;

    public static final int USER = 1;

    public Account() {
    }

    private int id;

    private String username;

    private String password;

    private String fullname;

    private byte role;

    private byte state;

    private Timestamp dateJoin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public byte getRole() {
        return role;
    }

    public void setRole(byte role) {
        this.role = role;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public Timestamp getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(Timestamp dateJoin) {
        this.dateJoin = dateJoin;
    }

    public void copyData(AccountEntity accountEntity) {

        this.id = accountEntity.getId();

        this.username = accountEntity.getUsername();

        this.password = accountEntity.getPassword();

        this.fullname = accountEntity.getFullname();

        this.role = accountEntity.getRole();

        this.state = accountEntity.getState();

        this.dateJoin = accountEntity.getDateJoin();
    }
}
