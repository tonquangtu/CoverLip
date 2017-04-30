package com.clteam.model;

import com.clteam.dataobject.*;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public class OneCardInfo {
    private VideoInfoEntity videoInfo;
    private AccountEntity account;
    private UserInfoEntity userInfo;
    private CoverInfoEntity coverInfo;

    public OneCardInfo(VideoInfoEntity videoInfo, AccountEntity account, UserInfoEntity userInfo, CoverInfoEntity coverInfo) {
        this.videoInfo = videoInfo;
        this.account = account;
        this.userInfo = userInfo;
        this.coverInfo = coverInfo;
    }

    public VideoInfoEntity getVideoInfo() {
        return videoInfo;
    }

    public void setVideoInfo(VideoInfoEntity videoInfo) {
        this.videoInfo = videoInfo;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public UserInfoEntity getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoEntity userInfo) {
        this.userInfo = userInfo;
    }

    public CoverInfoEntity getCoverInfo() {
        return coverInfo;
    }

    public void setCoverInfo(CoverInfoEntity coverInfo) {
        this.coverInfo = coverInfo;
    }
}
