package com.clteam.dataobject;

import javax.persistence.*;

/**
 * Created by Dell on 20-Apr-17.
 */
@Entity
@Table(name = "new_lipsync")
public class NewLipsync {
    private int id;
    private int videoId;
    private int priority;

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

        NewLipsync that = (NewLipsync) o;

        if (id != that.id) return false;
        if (videoId != that.videoId) return false;
        return priority == that.priority;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
        result = 31 * result + priority;
        return result;
    }


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
