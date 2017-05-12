package com.clteam.model;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.CoverOfPlaylistEntity;
import com.clteam.dataobject.PlaylistInfoEntity;
import com.clteam.dataobject.VideoInfoEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Dell on 30-Apr-17.
 */
public class Playlist {

    private int id;

    private String playlistName;

    private String playlistThumbnaiLink;

    private int numCover;

    private int numView;

    private Timestamp createDate;

    private byte state;

    private String description;

    private Account account;

    private List<PlaylistItem> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistThumbnaiLink() {
        return playlistThumbnaiLink;
    }

    public void setPlaylistThumbnaiLink(String playlistThumbnaiLink) {
        this.playlistThumbnaiLink = playlistThumbnaiLink;
    }

    public int getNumCover() {
        return numCover;
    }

    public void setNumCover(int numCover) {
        this.numCover = numCover;
    }

    public int getNumView() {
        return numView;
    }

    public void setNumView(int numView) {
        this.numView = numView;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<PlaylistItem> getItems() {
        return items;
    }

    public void setItems(List<PlaylistItem> items) {
        this.items = items;
    }

    public void copyData(PlaylistInfoEntity playlistInfoEntity){

        id = playlistInfoEntity.getId();

        playlistName = playlistInfoEntity.getPlaylistName();

        playlistThumbnaiLink = playlistInfoEntity.getPlaylistThumbnailLink();

        numCover = playlistInfoEntity.getNumCover();

        numView = playlistInfoEntity.getNumView();

        createDate = playlistInfoEntity.getCreateDate();

        state = playlistInfoEntity.getState();

        description = playlistInfoEntity.getDescription();

        if (account == null){
            account = new Account();
        }

        account.copyData(playlistInfoEntity.getAccountByAccountId());

        if (items == null){
            items = new ArrayList<PlaylistItem>();
        }

        Collection<CoverOfPlaylistEntity> coverOfPlaylistEntities = playlistInfoEntity.getCoverOfPlaylistsById();
        if (coverOfPlaylistEntities != null){

            for (int i=0; i < coverOfPlaylistEntities.size(); i++){

                PlaylistItem playlistItem = new PlaylistItem();

                CoverOfPlaylistEntity coverOfPlaylistEntity = (CoverOfPlaylistEntity) coverOfPlaylistEntities.toArray()[i];
                VideoInfoEntity videoInfoEntity = coverOfPlaylistEntity.getVideoInfoByVideoId();
                playlistItem.copyData(coverOfPlaylistEntity, videoInfoEntity);

                items.add(playlistItem);
            }
        }
    }
}
