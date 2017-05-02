package com.clteam.model;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.VideoInfoEntity;

import java.io.Serializable;

/**
 * Created by Dell on 30-Apr-17.
 */
public class Cover implements Serializable{

    public Cover() {
    }

    private Video video;

    private String coverName;

    private String mp3Link;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
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

    public void copyData(CoverInfoEntity coverInfoEntity, VideoInfoEntity videoInfoEntity){
        this.coverName = coverInfoEntity.getCoverName();
        this.mp3Link = coverInfoEntity.getMp3Link();
        this.video = new Video();
        AccountEntity accountEntity = videoInfoEntity.getAccountByAccountId();
        this.video.copyData(videoInfoEntity, accountEntity);
    }
}
