package com.clteam.dataobject;

import javax.persistence.*;

/**
 * Created by Dell on 28-Apr-17.
 */
@Entity
@Table(name = "hot_lip_sync")
public class HotLipSync {
    private int id;
    private int videoId;
    private int priority;
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
    @Column(name = "priority")
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotLipSync that = (HotLipSync) o;

        if (id != that.id) return false;
        if (videoId != that.videoId) return false;
        if (priority != that.priority) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
        result = 31 * result + priority;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "video_id", referencedColumnName = "id", nullable = false,insertable = false, updatable = false)
    public VideoInfo getVideoInfoByVideoId() {
        return videoInfoByVideoId;
    }

    public void setVideoInfoByVideoId(VideoInfo videoInfoByVideoId) {
        this.videoInfoByVideoId = videoInfoByVideoId;
    }
}
