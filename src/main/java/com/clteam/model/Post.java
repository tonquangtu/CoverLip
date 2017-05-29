package com.clteam.model;

/**
 * Created by Dell on 22-May-17.
 */
public class Post {

    private int accountId;

    private String title;

    private String description;

    private String videoLink;

    private String videoThumbnailLink;

    private String storageId;

    private int type;

    private int lipSyncTemplateId;

    public Post() {}


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLipSyncTemplateId() {
        return lipSyncTemplateId;
    }

    public void setLipSyncTemplateId(int lipSyncTemplateId) {
        this.lipSyncTemplateId = lipSyncTemplateId;
    }
}
