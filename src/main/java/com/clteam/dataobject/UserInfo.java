package com.clteam.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Dell on 20-Apr-17.
 */
@Entity
@Table(name = "user_info")
public class UserInfo {
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

    private Account account;

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
    @Column(name = "address", columnDefinition="TEXT")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "description", columnDefinition="TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "cover_image")
    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    @Basic
    @Column(name = "avatar_thumbnail")
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

        UserInfo userInfo = (UserInfo) o;

        if (id != userInfo.id) return false;
        if (accountId != userInfo.accountId) return false;
        if (numHaveFollowed != userInfo.numHaveFollowed) return false;
        if (numCover != userInfo.numCover) return false;
        if (numLipsync != userInfo.numLipsync) return false;
        if (numPlaylist != userInfo.numPlaylist) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(userInfo.dateOfBirth) : userInfo.dateOfBirth != null)
            return false;
        if (address != null ? !address.equals(userInfo.address) : userInfo.address != null) return false;
        if (description != null ? !description.equals(userInfo.description) : userInfo.description != null)
            return false;
        if (coverImage != null ? !coverImage.equals(userInfo.coverImage) : userInfo.coverImage != null) return false;
        return avatarThumbnail != null ? avatarThumbnail.equals(userInfo.avatarThumbnail) : userInfo.avatarThumbnail == null;
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
//
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name="account_id")
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

}
