package com.clteam.model;

import java.util.StringTokenizer;

/**
 * Created by Dell on 12-May-17.
 */
public class VideoWrapper {

    private String videoName;

    private Video video;

    private String mp3Link;

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
}
