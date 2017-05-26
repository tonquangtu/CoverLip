package com.clteam.model;

import com.clteam.dataconstant.DataConstant;
import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.VideoInfoEntity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Date;

/**
 * Created by Dell on 30-Apr-17.
 */
public class Video implements Serializable{

    public static final int COVER_TYPE = 1;

    public static final int LIP_SYNC_TYPE = 2;

    public static final byte ACTIVE_STATE = 1;

    public static final byte DEACTIVE_STATE = 0;


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

    private int type;

    private String storageId;


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
        if(storageId==null || storageId.length()<=0){
            return DataConstant.STORAGE_BASE_URL + videoThumbnailLink;
        }else{
            return videoThumbnailLink;
        }
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public void copyData(VideoInfoEntity videoEntity) {

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

        this.type = videoEntity.getType();

        this.storageId = videoEntity.getStorageId();
    }

    public String periodCreatedForNow() {

        String period = "";
        Date start = new Date(createDate.getTime());
        Date today = new Date(System.currentTimeMillis());

        Duration duration = Duration.between(start.toInstant(), today.toInstant());

        long minutes = duration.toMinutes();
       if (minutes == 0) {
           period = "Vừa mới đăng";
       } else if (minutes < 60) {
           period = "Đăng cách đây " + minutes + " phút";

       } else {

           long hours = duration.toHours();
           if (hours < 24) {
               period = "Đăng cách đây " + hours + " giờ";

           } else {

               long days = duration.toDays();
               if (days < 30) {
                   period = "Đăng cách đây " + days + " ngày";

               } else {

                   long months = days / 30;
                   if (months < 12) {
                       period = "Đăng cách đây " + months + " tháng";

                   } else {

                       long years = months / 12;
                       period = "Đăng cách đây " + years + " năm";
                   }
               }
           }
       }
       return period;
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

        this.type = videoEntity.getType();

        this.storageId = videoEntity.getStorageId();

        this.account = new Account();
        this.account.copyData(accountEntity);
    }
}
