package com.clteam.dataobject;

import javax.persistence.*;

/**
 * Created by Dell on 20-Apr-17.
 */
@Entity
@Table(name = "temp_new_cover_admin")
public class TempNewCoverAdmin {
    private int id;
    private int videoId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TempNewCoverAdmin that = (TempNewCoverAdmin) o;

        if (id != that.id) return false;
        return videoId == that.videoId;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
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
