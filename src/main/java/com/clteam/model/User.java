package com.clteam.model;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;

import java.sql.Timestamp;

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

    private String coverImage;

    private String avatarThumbnail;

    private Account account;

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

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getAvatarThumbnail() {
        return avatarThumbnail;
    }

    public void setAvatarThumbnail(String avatarThumbnail) {
        this.avatarThumbnail = avatarThumbnail;
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
        coverImage = userInfoEntity.getCoverImage();
        avatarThumbnail = userInfoEntity.getAvatarThumbnail();
        account = new Account();
        account.copyData(accountEntity);
    }

}