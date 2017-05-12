package com.clteam.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 03-May-17.
 */
public class PlaylistItem {

    private Cover item;

    private int playlistId;

    private Timestamp timeAdd;

    private int priority;

    public PlaylistItem() {

    }

    public Cover getItem() {
        return item;
    }

    public void setItem(Cover item) {
        this.item = item;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public Timestamp getTimeAdd() {
        return timeAdd;
    }

    public void setTimeAdd(Timestamp timeAdd) {
        this.timeAdd = timeAdd;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


}
