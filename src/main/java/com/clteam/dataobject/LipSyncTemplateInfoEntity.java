package com.clteam.dataobject;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Dell on 30-Apr-17.
 */
@Entity
@Table(name = "lip_sync_template_info")
public class LipSyncTemplateInfoEntity {
    private int id;
    private int videoId;
    private String lipSyncTemplateName;
    private int numLipSync;
    private Collection<LipSyncInfoEntity> lipSyncInfosById;
    private VideoInfoEntity videoInfoByVideoId;

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
    @Column(name = "lip_sync_template_name")
    public String getLipSyncTemplateName() {
        return lipSyncTemplateName;
    }

    public void setLipSyncTemplateName(String lipSyncTemplateName) {
        this.lipSyncTemplateName = lipSyncTemplateName;
    }

    @Basic
    @Column(name = "num_lip_sync")
    public int getNumLipSync() {
        return numLipSync;
    }

    public void setNumLipSync(int numLipSync) {
        this.numLipSync = numLipSync;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LipSyncTemplateInfoEntity that = (LipSyncTemplateInfoEntity) o;

        if (id != that.id) return false;
        if (videoId != that.videoId) return false;
        if (numLipSync != that.numLipSync) return false;
        if (lipSyncTemplateName != null ? !lipSyncTemplateName.equals(that.lipSyncTemplateName) : that.lipSyncTemplateName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
        result = 31 * result + (lipSyncTemplateName != null ? lipSyncTemplateName.hashCode() : 0);
        result = 31 * result + numLipSync;
        return result;
    }

    @OneToMany(mappedBy = "lipSyncTemplateInfoByLipSyncTemplateId")
    public Collection<LipSyncInfoEntity> getLipSyncInfosById() {
        return lipSyncInfosById;
    }

    public void setLipSyncInfosById(Collection<LipSyncInfoEntity> lipSyncInfosById) {
        this.lipSyncInfosById = lipSyncInfosById;
    }

    @ManyToOne
    @JoinColumn(name = "video_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public VideoInfoEntity getVideoInfoByVideoId() {
        return videoInfoByVideoId;
    }

    public void setVideoInfoByVideoId(VideoInfoEntity videoInfoByVideoId) {
        this.videoInfoByVideoId = videoInfoByVideoId;
    }
}
