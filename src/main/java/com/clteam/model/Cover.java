package com.clteam.model;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.VideoInfoEntity;

import java.io.Serializable;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Dell on 30-Apr-17.
 */
public class Cover implements Serializable {

    public Cover() {
    }

    public Cover(Video video, String coverName, String mp3Link) {
        this.video = video;
        this.coverName = coverName;
        this.mp3Link = mp3Link;
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

    public boolean equals(Cover equalCover) {

        if (equalCover == null || equalCover.getVideo() == null || this.video == null) {
            return false;
        }
        if (equalCover.getVideo().getId() == this.video.getId()) {
            return true;
        }

        return false;
    }

    public static boolean isExitsItem(Cover checkItem, List<Cover> list) {
        if (checkItem == null || list == null || list.size() <= 0) {
            return false;
        }
        boolean isExists = false;
        try {
            int checkItemId = checkItem.getVideo().getId();
            for (Cover item : list) {

                if (item.getVideo().getId() == checkItemId) {
                    isExists = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //   System.out.println("IsExits: " + isExists);
        return isExists;
    }

    public VideoWrapper toVideoWrapper() {
        VideoWrapper videoWrapper = new VideoWrapper();
        videoWrapper.setVideo(this.video);
        videoWrapper.setVideoName(this.coverName);
        videoWrapper.setMp3Link(this.mp3Link);

        return videoWrapper;
    }


    public void copyData(CoverInfoEntity coverInfoEntity, VideoInfoEntity videoInfoEntity, AccountEntity accountEntity) {
        this.coverName = coverInfoEntity.getCoverName();
        this.mp3Link = coverInfoEntity.getMp3Link();
        this.video = new Video();
        this.video.copyData(videoInfoEntity, accountEntity);
    }

    public String compactNameCover(int numWord) {
        StringBuilder result = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(this.coverName, " ");
        if (stringTokenizer.countTokens() <= numWord) {
            return this.coverName;
        }
        int count = 0;
        while (stringTokenizer.hasMoreTokens() && count < numWord) {
            result.append(stringTokenizer.nextToken()).append(" ");
            count++;
        }

        return result.toString().trim() + "...";
    }
}
