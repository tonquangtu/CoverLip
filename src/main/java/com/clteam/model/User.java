package com.clteam.model;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;

import java.sql.Timestamp;
import java.util.Collection;
import java.text.SimpleDateFormat;

/**
 * Created by Dell on 30-Apr-17.
 */
public class User {

    private int numHaveFollowed;

    private int numCover;

    private int numLipsync;

    private int numPlaylist;

    private Timestamp dateOfBirth;

    private String address;

    private String description;

    private Account account;

    public User() {
    }

    public User(AccountEntity accountEntity) {
        Collection<UserInfoEntity> userInfoEntity = accountEntity.getUserInfosById();
        if (userInfoEntity != null && !userInfoEntity.isEmpty()) {
            copyData(userInfoEntity.iterator().next(), accountEntity);
        } else {
            account = new Account();
            account.copyData(accountEntity);
        }
    }

    public int getNumHaveFollowed() {
        return numHaveFollowed;
    }

    public void setNumHaveFollowed(int numHaveFollowed) {
        this.numHaveFollowed = numHaveFollowed;
    }

    public int getNumCover() {
        return numCover;
    }

    public void setNumCover(int numCover) {
        this.numCover = numCover;
    }

    public int getNumLipsync() {
        return numLipsync;
    }

    public void setNumLipsync(int numLipsync) {
        this.numLipsync = numLipsync;
    }

    public int getNumPlaylist() {
        return numPlaylist;
    }

    public void setNumPlaylist(int numPlaylist) {
        this.numPlaylist = numPlaylist;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void copyData(UserInfoEntity userInfoEntity, AccountEntity accountEntity){

        numHaveFollowed = userInfoEntity.getNumHaveFollowed();
        numCover = userInfoEntity.getNumCover();
        numLipsync = userInfoEntity.getNumLipsync();
        numPlaylist = userInfoEntity.getNumPlaylist();
        dateOfBirth = userInfoEntity.getDateOfBirth();
        address = userInfoEntity.getAddress();
        description = userInfoEntity.getDescription();
        account = new Account();
        account.copyData(accountEntity);
    }

    public void copyData(UserInfoEntity userEntity) {
        this.numHaveFollowed = userEntity.getNumHaveFollowed();

        this.numCover = userEntity.getNumCover();

        this.numLipsync = userEntity.getNumLipsync();

        this.numPlaylist = userEntity.getNumPlaylist();

       this.dateOfBirth = userEntity.getDateOfBirth();

        this.address = userEntity.getAddress();

        this.description = userEntity.getDescription();
    }

    public String formatTimestamp(Timestamp timestamp){
        String date = new SimpleDateFormat("dd/MM/yyyy").format(timestamp);
        return date;
    }
}