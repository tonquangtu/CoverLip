package com.clteam.model;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public class OneCardInfo {
    private VideoInfo videoInfo;
    private Account account;
    private UserInfo userInfo;
    private CoverInfo coverInfo;

    public OneCardInfo(VideoInfo videoInfo, Account account, UserInfo userInfo, CoverInfo coverInfo) {
        this.videoInfo = videoInfo;
        this.account = account;
        this.userInfo = userInfo;
        this.coverInfo = coverInfo;
    }

    public VideoInfo getVideoInfo() {
        return videoInfo;
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public CoverInfo getCoverInfo() {
        return coverInfo;
    }

    public void setCoverInfo(CoverInfo coverInfo) {
        this.coverInfo = coverInfo;
    }
}
