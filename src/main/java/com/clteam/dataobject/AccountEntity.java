package com.clteam.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Dell on 30-Apr-17.
 */
@Entity
@Table(name = "account")
public class AccountEntity {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private byte role;
    private byte state;
    private Timestamp dateJoin;
    private String coverImage;
    private String avatarThumbnail;
    private Collection<AdminInfoEntity> adminInfosById;
    private Collection<IdolFollowingEntity> idolFollowingsById;
    private Collection<IdolFollowingEntity> idolFollowingsById_0;
    private Collection<PlaylistInfoEntity> playlistInfosById;
    private Collection<TopCoverIdolEntity> topCoverIdolsById;
    private Collection<TopLipSyncIdolEntity> topLipSyncIdolsById;
    private Collection<UserInfoEntity> userInfosById;
    private Collection<VideoInfoEntity> videoInfosById;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "fullname")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "role")
    public byte getRole() {
        return role;
    }

    public void setRole(byte role) {
        this.role = role;
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
    @Column(name = "date_join")
    public Timestamp getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(Timestamp dateJoin) {
        this.dateJoin = dateJoin;
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

        AccountEntity that = (AccountEntity) o;

        if (id != that.id) return false;
        if (role != that.role) return false;
        if (state != that.state) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (fullname != null ? !fullname.equals(that.fullname) : that.fullname != null) return false;
        if (dateJoin != null ? !dateJoin.equals(that.dateJoin) : that.dateJoin != null) return false;
        if (coverImage != null ? !coverImage.equals(that.coverImage) : that.coverImage != null) return false;
        if (avatarThumbnail != null ? !avatarThumbnail.equals(that.avatarThumbnail) : that.avatarThumbnail != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (int) role;
        result = 31 * result + (int) state;
        result = 31 * result + (dateJoin != null ? dateJoin.hashCode() : 0);
        result = 31 * result + (coverImage != null ? coverImage.hashCode() : 0);
        result = 31 * result + (avatarThumbnail != null ? avatarThumbnail.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<AdminInfoEntity> getAdminInfosById() {
        return adminInfosById;
    }

    public void setAdminInfosById(Collection<AdminInfoEntity> adminInfosById) {
        this.adminInfosById = adminInfosById;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<IdolFollowingEntity> getIdolFollowingsById() {
        return idolFollowingsById;
    }

    public void setIdolFollowingsById(Collection<IdolFollowingEntity> idolFollowingsById) {
        this.idolFollowingsById = idolFollowingsById;
    }

    @OneToMany(mappedBy = "accountByFollowedAccountId")
    public Collection<IdolFollowingEntity> getIdolFollowingsById_0() {
        return idolFollowingsById_0;
    }

    public void setIdolFollowingsById_0(Collection<IdolFollowingEntity> idolFollowingsById_0) {
        this.idolFollowingsById_0 = idolFollowingsById_0;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<PlaylistInfoEntity> getPlaylistInfosById() {
        return playlistInfosById;
    }

    public void setPlaylistInfosById(Collection<PlaylistInfoEntity> playlistInfosById) {
        this.playlistInfosById = playlistInfosById;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<TopCoverIdolEntity> getTopCoverIdolsById() {
        return topCoverIdolsById;
    }

    public void setTopCoverIdolsById(Collection<TopCoverIdolEntity> topCoverIdolsById) {
        this.topCoverIdolsById = topCoverIdolsById;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<TopLipSyncIdolEntity> getTopLipSyncIdolsById() {
        return topLipSyncIdolsById;
    }

    public void setTopLipSyncIdolsById(Collection<TopLipSyncIdolEntity> topLipSyncIdolsById) {
        this.topLipSyncIdolsById = topLipSyncIdolsById;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<UserInfoEntity> getUserInfosById() {
        return userInfosById;
    }

    public void setUserInfosById(Collection<UserInfoEntity> userInfosById) {
        this.userInfosById = userInfosById;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<VideoInfoEntity> getVideoInfosById() {
        return videoInfosById;
    }

    public void setVideoInfosById(Collection<VideoInfoEntity> videoInfosById) {
        this.videoInfosById = videoInfosById;
    }
}
