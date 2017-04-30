package com.clteam.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Dell on 30-Apr-17.
 */
@Entity
@Table(name = "user_info")
public class UserInfoEntity {
    private int id;
    private int accountId;
    private int numHaveFollowed;
    private int numCover;
    private int numLipsync;
    private int numPlaylist;
    private Timestamp dateOfBirth;
    private String address;
    private String description;
    private String coverImage;
    private String avatarThumbnail;
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
    @Column(name = "num_have_followed")
    public int getNumHaveFollowed() {
        return numHaveFollowed;
    }

    public void setNumHaveFollowed(int numHaveFollowed) {
        this.numHaveFollowed = numHaveFollowed;
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
    @Column(name = "num_lipsync")
    public int getNumLipsync() {
        return numLipsync;
    }

    public void setNumLipsync(int numLipsync) {
        this.numLipsync = numLipsync;
    }

    @Basic
    @Column(name = "num_playlist")
    public int getNumPlaylist() {
        return numPlaylist;
    }

    public void setNumPlaylist(int numPlaylist) {
        this.numPlaylist = numPlaylist;
    }

    @Basic
    @Column(name = "date_of_birth")
    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "address", columnDefinition = "TEXT")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "cover_image", columnDefinition = "TEXT")
    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    @Basic
    @Column(name = "avatar_thumbnail", columnDefinition = "TEXT")
    public String getAvatarThumbnail() {
        return avatarThumbnail;
    }

    public void setAvatarThumbnail(String avatarThumbnail) {
        this.avatarThumbnail = avatarThumbnail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoEntity that = (UserInfoEntity) o;

        if (id != that.id) return false;
        if (accountId != that.accountId) return false;
        if (numHaveFollowed != that.numHaveFollowed) return false;
        if (numCover != that.numCover) return false;
        if (numLipsync != that.numLipsync) return false;
        if (numPlaylist != that.numPlaylist) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (coverImage != null ? !coverImage.equals(that.coverImage) : that.coverImage != null) return false;
        if (avatarThumbnail != null ? !avatarThumbnail.equals(that.avatarThumbnail) : that.avatarThumbnail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + accountId;
        result = 31 * result + numHaveFollowed;
        result = 31 * result + numCover;
        result = 31 * result + numLipsync;
        result = 31 * result + numPlaylist;
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (coverImage != null ? coverImage.hashCode() : 0);
        result = 31 * result + (avatarThumbnail != null ? avatarThumbnail.hashCode() : 0);
        return result;
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
