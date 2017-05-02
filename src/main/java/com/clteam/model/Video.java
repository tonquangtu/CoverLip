package com.clteam.model;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.VideoInfoEntity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by Dell on 30-Apr-17.
 */
public class Video implements Serializable{
    public Video() {
    }

    private int id;

    private String videoLink;

    private String videoThumbnailLink;

    private Time duration;

    private Timestamp createDate;

    private int numView;

    private int numLike;

    private int numComment;

    private byte state;

    private String description;

    private Account account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getVideoThumbnailLink() {
        return videoThumbnailLink;
    }

    public void setVideoThumbnailLink(String videoThumbnailLink) {
        this.videoThumbnailLink = videoThumbnailLink;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getNumView() {
        return numView;
    }

    public void setNumView(int numView) {
        this.numView = numView;
    }

    public int getNumLike() {
        return numLike;
    }

    public void setNumLike(int numLike) {
        this.numLike = numLike;
    }

    public int getNumComment() {
        return numComment;
    }

    public void setNumComment(int numComment) {
        this.numComment = numComment;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
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

    public void copyData(VideoInfoEntity videoEntity, AccountEntity accountEntity) {

        id = videoEntity.getId();

        videoLink = videoEntity.getVideoLink();

        videoThumbnailLink = videoEntity.getVideoThumbnailLink();

        duration = videoEntity.getDuration();

        createDate = videoEntity.getCreateDate();

        numView = videoEntity.getNumView();

        numLike = videoEntity.getNumLike();

        numComment = videoEntity.getNumComment();

        state = videoEntity.getState();

        description = videoEntity.getDescription();

        this.account = new Account();
        this.account.copyData(accountEntity);
    }
}
