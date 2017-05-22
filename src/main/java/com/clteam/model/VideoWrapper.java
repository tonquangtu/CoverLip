package com.clteam.model;

import com.clteam.dataconstant.DataConstant;
import com.clteam.utils.CommonUtils;

import java.util.StringTokenizer;

/**
 * Created by Dell on 12-May-17.
 */
public class VideoWrapper {

    private String videoName;

    private Video video;

    private String mp3Link;

    private String fullLink;

    public VideoWrapper() {

    }

    public VideoWrapper(String videoName, Video video) {
        this.video = video;
        this.videoName = videoName;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getMp3Link() {
        return mp3Link;
    }

    public void setMp3Link(String mp3Link) {
        this.mp3Link = mp3Link;
    }

    public String compactNameCover(int numWord) {
        StringBuilder result = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(this.videoName, " ");
        if (stringTokenizer.countTokens() <= numWord) {
            return this.videoName;
        }
        int count = 0;
        while (stringTokenizer.hasMoreTokens() && count < numWord) {
            result.append(stringTokenizer.nextToken()).append(" ");
            count++;
        }

        return result.toString().trim() + " ...";
    }

    public String compactNameVideo(int numWord){
        return compactNameCover(numWord);
    }

    public String getFullVideoLink(String subBaseUrl) {
        String fullLink = DataConstant.BASE_URL + subBaseUrl + "/";
        try {
//
//            if (video == null) {
//                System.out.println("Video null");
//            } else if(video.getAccount() == null) {
//                System.out.println("Account null");
//            }

            String newOwnerName = CommonUtils.transformToSluxSearch(video.getAccount().getFullname());
            String newVideoName = CommonUtils.transformToSluxSearch(videoName);

            fullLink += newOwnerName + "-" + newVideoName + "/" + video.getId();
//            System.out.println("Full link video: " + fullLink);

        }catch (Exception e) {
            e.printStackTrace();
        }

        return fullLink;
    }

    public void setFullLink() {

        String subBaseUrl = "";
        if (video.getType() == Video.COVER_TYPE) {
            subBaseUrl = DataConstant.COVER_BASE_URL;
        } else if (video.getType() == Video.LIP_SYNC_TYPE) {
            subBaseUrl = DataConstant.LIP_SYNC_BASE_URL;
        } else {
            subBaseUrl = DataConstant.LIP_SYNC_BASE_URL;
        }

        this.fullLink = getFullVideoLink(subBaseUrl);
    }

}
