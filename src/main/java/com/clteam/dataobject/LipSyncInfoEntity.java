package com.clteam.dataobject;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;

/**
 * Created by Dell on 30-Apr-17.
 */
@Indexed
@Entity
@Table(name = "lip_sync_info")
public class LipSyncInfoEntity {
    private int id;
    private int videoId;
    private int lipSyncTemplateId;
    private VideoInfoEntity videoInfoByVideoId;
    private LipSyncTemplateInfoEntity lipSyncTemplateInfoByLipSyncTemplateId;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

        LipSyncInfoEntity that = (LipSyncInfoEntity) o;

        if (id != that.id) return false;
        if (videoId != that.videoId) return false;
        if (lipSyncTemplateId != that.lipSyncTemplateId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
        result = 31 * result + lipSyncTemplateId;
        return result;
    }

    @IndexedEmbedded
    @ManyToOne
    @JoinColumn(name = "video_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public VideoInfoEntity getVideoInfoByVideoId() {
        return videoInfoByVideoId;
    }

    public void setVideoInfoByVideoId(VideoInfoEntity videoInfoByVideoId) {
        this.videoInfoByVideoId = videoInfoByVideoId;
    }

    @IndexedEmbedded
    @ManyToOne
    @JoinColumn(name = "lip_sync_template_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public LipSyncTemplateInfoEntity getLipSyncTemplateInfoByLipSyncTemplateId() {
        return lipSyncTemplateInfoByLipSyncTemplateId;
    }

    public void setLipSyncTemplateInfoByLipSyncTemplateId(LipSyncTemplateInfoEntity lipSyncTemplateInfoByLipSyncTemplateId) {
        this.lipSyncTemplateInfoByLipSyncTemplateId = lipSyncTemplateInfoByLipSyncTemplateId;
    }
}
