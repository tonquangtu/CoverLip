package com.clteam.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Dell on 20-Apr-17.
 */
@Entity
@Table(name = "cover_of_playlist", schema = "coverlip", catalog = "")
public class CoverOfPlaylist {
    private int id;
    private int videoId;
    private int playlistId;
    private Timestamp timeAdd;
    private int priority;

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
    @Column(name = "playlist_id")
    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    @Basic
    @Column(name = "time_add")
    public Timestamp getTimeAdd() {
        return timeAdd;
    }

    public void setTimeAdd(Timestamp timeAdd) {
        this.timeAdd = timeAdd;
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

        CoverOfPlaylist that = (CoverOfPlaylist) o;

        if (id != that.id) return false;
        if (videoId != that.videoId) return false;
        if (playlistId != that.playlistId) return false;
        if (priority != that.priority) return false;
        if (timeAdd != null ? !timeAdd.equals(that.timeAdd) : that.timeAdd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
        result = 31 * result + playlistId;
        result = 31 * result + (timeAdd != null ? timeAdd.hashCode() : 0);
        result = 31 * result + priority;
        return result;
    }
}
