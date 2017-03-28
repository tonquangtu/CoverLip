package com.clteam.model;

import javax.persistence.*;

/**
 * Created by Khanh Nguyen on 28/3/2017.
 */
@Entity
@Table(name = "cover_info", schema = "coverlip", catalog = "")
public class CoverInfo {
    private int id;
    private int videoId;
    private String coverName;
    private String mp3Link;
    private VideoInfo videoInfoByVideoId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "video_id")
    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    @Basic
    @Column(name = "cover_name")
    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    @Basic
    @Column(name = "mp3_link")
    public String getMp3Link() {
        return mp3Link;
    }

    public void setMp3Link(String mp3Link) {
        this.mp3Link = mp3Link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoverInfo coverInfo = (CoverInfo) o;

        if (id != coverInfo.id) return false;
        if (videoId != coverInfo.videoId) return false;
        if (coverName != null ? !coverName.equals(coverInfo.coverName) : coverInfo.coverName != null) return false;
        if (mp3Link != null ? !mp3Link.equals(coverInfo.mp3Link) : coverInfo.mp3Link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
        result = 31 * result + (coverName != null ? coverName.hashCode() : 0);
        result = 31 * result + (mp3Link != null ? mp3Link.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "video_id", referencedColumnName = "id", nullable = false)
    public VideoInfo getVideoInfoByVideoId() {
        return videoInfoByVideoId;
    }

    public void setVideoInfoByVideoId(VideoInfo videoInfoByVideoId) {
        this.videoInfoByVideoId = videoInfoByVideoId;
    }
}
