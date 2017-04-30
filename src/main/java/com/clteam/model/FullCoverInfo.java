package com.clteam.model;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by Dell on 29-Apr-17.
 */
public class FullCoverInfo {

    private long videoId;

    private String coverName;

    private String mp3Link;

    private long accountId;

    private String videoLink;

    private String videoThumbnailLink;

    private Time duration;

    private Timestamp createDate;

    private int numLike;

    private int numView;

    private int numComment;

    private byte state;

    private String description;

    public long getVideoId() {
        return videoId;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }

    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    public String getMp3Link() {
        return mp3Link;
    }

    public void setMp3Link(String mp3Link) {
        this.mp3Link = mp3Link;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
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

    public int getNumLike() {
        return numLike;
    }

    public void setNumLike(int numLike) {
        this.numLike = numLike;
    }

    public int getNumView() {
        return numView;
    }

    public void setNumView(int numView) {
        this.numView = numView;
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

    public void copyData(CoverInfo cover,VideoInfo video) {

        videoId = cover.getVideoId();

        coverName = cover.getCoverName();

        mp3Link = cover.getMp3Link();

        accountId = video.getAccountId();

        videoLink = video.getVideoLink();

        videoThumbnailLink = video.getVideoThumbnailLink();

        duration = video.getDuration();

        createDate = video.getCreateDate();

        numLike = video.getNumLike();

        numView = video.getNumView();

        numComment  = video.getNumComment();

        state = video.getState();

        description = video.getDescription();

    }
}
