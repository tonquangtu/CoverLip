package com.clteam.dataobject;

import javax.persistence.*;

/**
 * Created by Dell on 28-Apr-17.
 */
@Entity
@Table(name = "lip_sync_info")
public class LipSyncInfo {
    private int id;
    private int videoId;
    private int lipSyncTemplateId;

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
    @Column(name = "lip_sync_template_id")
    public int getLipSyncTemplateId() {
        return lipSyncTemplateId;
    }

    public void setLipSyncTemplateId(int lipSyncTemplateId) {
        this.lipSyncTemplateId = lipSyncTemplateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LipSyncInfo that = (LipSyncInfo) o;

        if (id != that.id) return false;
        if (videoId != that.videoId) return false;
        return lipSyncTemplateId == that.lipSyncTemplateId;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
        result = 31 * result + lipSyncTemplateId;
        return result;
    }
}
