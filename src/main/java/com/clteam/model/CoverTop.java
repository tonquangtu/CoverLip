package com.clteam.model;

import javax.persistence.*;

/**
 * Created by Khanh Nguyen on 28/3/2017.
 */
@Entity
@Table(name = "cover_top", schema = "coverlip", catalog = "")
public class CoverTop {
    private int id;
    private int videoId;
    private int topId;
    private int numViewPeriod;
    private VideoInfo videoInfoByVideoId;
    private TopList topListByTopId;

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
    @Column(name = "top_id")
    public int getTopId() {
        return topId;
    }

    public void setTopId(int topId) {
        this.topId = topId;
    }

    @Basic
    @Column(name = "num_view_period")
    public int getNumViewPeriod() {
        return numViewPeriod;
    }

    public void setNumViewPeriod(int numViewPeriod) {
        this.numViewPeriod = numViewPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoverTop coverTop = (CoverTop) o;

        if (id != coverTop.id) return false;
        if (videoId != coverTop.videoId) return false;
        if (topId != coverTop.topId) return false;
        if (numViewPeriod != coverTop.numViewPeriod) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
        result = 31 * result + topId;
        result = 31 * result + numViewPeriod;
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

    @ManyToOne
    @JoinColumn(name = "top_id", referencedColumnName = "id", nullable = false)
    public TopList getTopListByTopId() {
        return topListByTopId;
    }

    public void setTopListByTopId(TopList topListByTopId) {
        this.topListByTopId = topListByTopId;
    }
}
