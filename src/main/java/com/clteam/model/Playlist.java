package com.clteam.model;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.PlaylistInfoEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
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

    public Playlist() {
        items = new ArrayList<>();
        account = new Account();
    }

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

    public void addItem(PlaylistItem item) {
        items.add(item);
    }

    public void copyData(PlaylistInfoEntity playlistEntity) {

        this.id = playlistEntity.getId();

        this.playlistName = playlistEntity.getPlaylistName();

        this.playlistThumbnaiLink = playlistEntity.getPlaylistThumbnailLink();

        this.numCover = playlistEntity.getNumCover();

        this.numView = playlistEntity.getNumView();

        this.createDate = playlistEntity.getCreateDate();

        this.state = playlistEntity.getState();

        this.description = playlistEntity.getDescription();

        if (account == null) {
            account = new Account();
        }
        this.account.setId(playlistEntity.getAccountId());

    }

    public void copyData(PlaylistInfoEntity playlistEntity, List<PlaylistItem> items, AccountEntity accountEntity) {

        this.id = playlistEntity.getId();

        this.playlistName = playlistEntity.getPlaylistName();

        this.playlistThumbnaiLink = playlistEntity.getPlaylistThumbnailLink();

        this.numCover = playlistEntity.getNumCover();

        this.numView = playlistEntity.getNumView();

        this.createDate = playlistEntity.getCreateDate();

        this.state = playlistEntity.getState();

        this.description = playlistEntity.getDescription();

        this.items = items;
        if (account == null) {
            account = new Account();
        }
        this.account.copyData(accountEntity);
    }
    public List<Cover> getCoverInPlaylist() {

        List<Cover> covers = new ArrayList<>();
        if (items != null && items.size() > 0) {

            for (PlaylistItem item : items) {
                covers.add(item.getItem());
            }
        }
        return covers;
    }
}
