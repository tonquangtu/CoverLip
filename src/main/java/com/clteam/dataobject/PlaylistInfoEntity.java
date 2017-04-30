package com.clteam.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Dell on 30-Apr-17.
 */
@Entity
@Table(name = "playlist_info")
public class PlaylistInfoEntity {
    private int id;
    private int accountId;
    private String playlistName;
    private String playlistThumbnailLink;
    private int numCover;
    private int numView;
    private Timestamp createDate;
    private byte state;
    private String description;
    private Collection<CoverOfPlaylistEntity> coverOfPlaylistsById;
    private AccountEntity accountByAccountId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account_id")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "playlist_name")
    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    @Basic
    @Column(name = "playlist_thumbnail_link",columnDefinition = "TEXT")
    public String getPlaylistThumbnailLink() {
        return playlistThumbnailLink;
    }

    public void setPlaylistThumbnailLink(String playlistThumbnailLink) {
        this.playlistThumbnailLink = playlistThumbnailLink;
    }

    @Basic
    @Column(name = "num_cover")
    public int getNumCover() {
        return numCover;
    }

    public void setNumCover(int numCover) {
        this.numCover = numCover;
    }

    @Basic
    @Column(name = "num_view")
    public int getNumView() {
        return numView;
    }

    public void setNumView(int numView) {
        this.numView = numView;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "state")
    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    @Basic
    @Column(name = "description",columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaylistInfoEntity that = (PlaylistInfoEntity) o;

        if (id != that.id) return false;
        if (accountId != that.accountId) return false;
        if (numCover != that.numCover) return false;
        if (numView != that.numView) return false;
        if (state != that.state) return false;
        if (playlistName != null ? !playlistName.equals(that.playlistName) : that.playlistName != null) return false;
        if (playlistThumbnailLink != null ? !playlistThumbnailLink.equals(that.playlistThumbnailLink) : that.playlistThumbnailLink != null)
            return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + accountId;
        result = 31 * result + (playlistName != null ? playlistName.hashCode() : 0);
        result = 31 * result + (playlistThumbnailLink != null ? playlistThumbnailLink.hashCode() : 0);
        result = 31 * result + numCover;
        result = 31 * result + numView;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (int) state;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "playlistInfoByPlaylistId")
    public Collection<CoverOfPlaylistEntity> getCoverOfPlaylistsById() {
        return coverOfPlaylistsById;
    }

    public void setCoverOfPlaylistsById(Collection<CoverOfPlaylistEntity> coverOfPlaylistsById) {
        this.coverOfPlaylistsById = coverOfPlaylistsById;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public AccountEntity getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(AccountEntity accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }
}
