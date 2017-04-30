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
    private String lipsyncTemplateName;
    private int numLipsync;
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
    @Column(name = "lipsync_template_name")
    public String getLipsyncTemplateName() {
        return lipsyncTemplateName;
    }

    public void setLipsyncTemplateName(String lipsyncTemplateName) {
        this.lipsyncTemplateName = lipsyncTemplateName;
    }

    @Basic
    @Column(name = "num_lipsync")
    public int getNumLipsync() {
        return numLipsync;
    }

    public void setNumLipsync(int numLipsync) {
        this.numLipsync = numLipsync;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LipSyncTemplateInfoEntity that = (LipSyncTemplateInfoEntity) o;

        if (id != that.id) return false;
        if (videoId != that.videoId) return false;
        if (numLipsync != that.numLipsync) return false;
        if (lipsyncTemplateName != null ? !lipsyncTemplateName.equals(that.lipsyncTemplateName) : that.lipsyncTemplateName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
        result = 31 * result + (lipsyncTemplateName != null ? lipsyncTemplateName.hashCode() : 0);
        result = 31 * result + numLipsync;
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
