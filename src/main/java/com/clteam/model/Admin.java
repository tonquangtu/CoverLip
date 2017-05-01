package com.clteam.model;

import java.io.Serializable;

/**
 * Created by Dell on 30-Apr-17.
 */
public class Admin implements Serializable{

    public Admin() {
    }

    private String profileImage;

    private String phoneNumber;

    private String address;

    private Account account;

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
