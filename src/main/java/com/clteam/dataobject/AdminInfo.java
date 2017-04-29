package com.clteam.dataobject;

import javax.persistence.*;

/**
 * Created by Dell on 20-Apr-17.
 */
@Entity
@Table(name = "admin_info")
public class AdminInfo {
    private int id;
    private int accountId;
    private String profileImage;
    private String phoneNumber;
    private String address;

    private Account account;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account_id")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "profile_image")
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "address", columnDefinition="TEXT")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminInfo adminInfo = (AdminInfo) o;

        if (id != adminInfo.id) return false;
        if (accountId != adminInfo.accountId) return false;
        if (profileImage != null ? !profileImage.equals(adminInfo.profileImage) : adminInfo.profileImage != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(adminInfo.phoneNumber) : adminInfo.phoneNumber != null)
            return false;
        return address != null ? address.equals(adminInfo.address) : adminInfo.address == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + accountId;
        result = 31 * result + (profileImage != null ? profileImage.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name="account_id")
//    public Account getAccount() {
//        return account;
//    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
