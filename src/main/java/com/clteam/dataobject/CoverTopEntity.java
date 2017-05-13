package com.clteam.dataobject;

import org.hibernate.search.annotations.*;

import javax.persistence.*;

/**
 * Created by Dell on 30-Apr-17.
 */
@Entity
@Table(name = "cover_top")
public class CoverTopEntity {
    private int id;
    private int videoId;
    private int topId;
    private int numViewPeriod;
    private VideoInfoEntity videoInfoByVideoId;
    private TopListEntity topListByTopId;

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

        CoverTopEntity that = (CoverTopEntity) o;

        if (id != that.id) return false;
        if (videoId != that.videoId) return false;
        if (topId != that.topId) return false;
        if (numViewPeriod != that.numViewPeriod) return false;

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
    @JoinColumn(name = "video_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public VideoInfoEntity getVideoInfoByVideoId() {
        return videoInfoByVideoId;
    }

    public void setVideoInfoByVideoId(VideoInfoEntity videoInfoByVideoId) {
        this.videoInfoByVideoId = videoInfoByVideoId;
    }

    @ManyToOne
    @JoinColumn(name = "top_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public TopListEntity getTopListByTopId() {
        return topListByTopId;
    }

    public void setTopListByTopId(TopListEntity topListByTopId) {
        this.topListByTopId = topListByTopId;
    }
}
