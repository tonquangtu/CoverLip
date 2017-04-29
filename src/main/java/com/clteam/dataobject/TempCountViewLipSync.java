package com.clteam.dataobject;

import javax.persistence.*;

/**
 * Created by Dell on 20-Apr-17.
 */
@Entity
@Table(name = "temp_count_view_lip_sync")
public class TempCountViewLipSync {
    private int id;
    private int videoId;
    private int numView;
    private int week;
    private int year;

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
    @Column(name = "num_view")
    public int getNumView() {
        return numView;
    }

    public void setNumView(int numView) {
        this.numView = numView;
    }

    @Basic
    @Column(name = "week")
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TempCountViewLipSync that = (TempCountViewLipSync) o;

        if (id != that.id) return false;
        if (videoId != that.videoId) return false;
        if (numView != that.numView) return false;
        if (week != that.week) return false;
        return year == that.year;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
        result = 31 * result + numView;
        result = 31 * result + week;
        result = 31 * result + year;
        return result;
    }

//
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name="video_id")
//    public VideoInfo getVideoInfo() {
//        return videoInfo;
//    }
//
//    public void setVideoInfo(VideoInfo videoInfo) {
//        this.videoInfo = videoInfo;
//    }
}
