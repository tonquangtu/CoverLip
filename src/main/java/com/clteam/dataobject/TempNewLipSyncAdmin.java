package com.clteam.dataobject;

import javax.persistence.*;

/**
 * Created by Dell on 28-Apr-17.
 */
@Entity
@Table(name = "temp_new_lip_sync_admin")
public class TempNewLipSyncAdmin {
    private int id;
    private int videoId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TempNewLipSyncAdmin that = (TempNewLipSyncAdmin) o;

        if (id != that.id) return false;
        if (videoId != that.videoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
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
