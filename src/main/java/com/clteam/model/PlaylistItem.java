package com.clteam.model;

import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.CoverOfPlaylistEntity;
import com.clteam.dataobject.VideoInfoEntity;

import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by mrgnu on 05/05/2017.
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

    public void copyData(CoverOfPlaylistEntity coverOfPlaylistEntity, VideoInfoEntity videoInfoEntity){

        if (item == null){

            item = new Cover();
        }

        Collection<CoverInfoEntity> coverInfoEntities =  videoInfoEntity.getCoverInfosById();
        if (coverInfoEntities != null){

            CoverInfoEntity coverInfoEntity = (CoverInfoEntity) coverInfoEntities.toArray()[0];
            item.copyData(coverInfoEntity, videoInfoEntity);
        }

        playlistId = coverOfPlaylistEntity.getPlaylistId();

        timeAdd = coverOfPlaylistEntity.getTimeAdd();

        priority = coverOfPlaylistEntity.getPriority();


    }
}
