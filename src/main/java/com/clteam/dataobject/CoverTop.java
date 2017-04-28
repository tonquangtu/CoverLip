package com.clteam.dataobject;

import javax.persistence.*;

/**
 * Created by Dell on 20-Apr-17.
 */
@Entity
@Table(name = "cover_top", schema = "coverlip")
public class CoverTop {
    private int id;
    private int videoId;
    private int topId;
    private int numViewPeriod;

    private TopList topList;

    private VideoInfo videoInfo;

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
        return numViewPeriod == coverTop.numViewPeriod;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
        result = 31 * result + topId;
        result = 31 * result + numViewPeriod;
        return result;
    }

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name="top_id")
//    public TopList getTopList() {
//        return topList;
//    }

//    public void setTopList(TopList topList) {
//        this.topList = topList;
//    }
//
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name="video_id")
//    public VideoInfo getVideoInfo() {
//        return videoInfo;
//    }

//    public void setVideoInfo(VideoInfo videoInfo) {
//        this.videoInfo = videoInfo;
//    }
}
