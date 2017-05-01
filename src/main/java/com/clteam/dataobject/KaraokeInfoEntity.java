package com.clteam.dataobject;

import javax.persistence.*;

/**
 * Created by Dell on 30-Apr-17.
 */
@Entity
@Table(name = "karaoke_info")
public class KaraokeInfoEntity {
    private int id;
    private int videoId;
    private String karaokeName;
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
    @Column(name = "karaoke_name")
    public String getKaraokeName() {
        return karaokeName;
    }

    public void setKaraokeName(String karaokeName) {
        this.karaokeName = karaokeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KaraokeInfoEntity that = (KaraokeInfoEntity) o;

        if (id != that.id) return false;
        if (videoId != that.videoId) return false;
        if (karaokeName != null ? !karaokeName.equals(that.karaokeName) : that.karaokeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
        result = 31 * result + (karaokeName != null ? karaokeName.hashCode() : 0);
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
}
