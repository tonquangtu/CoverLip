package com.clteam.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Created by Dell on 28-Apr-17.
 */
@Entity
@Table(name = "account")
public class Account {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private byte role;
    private byte state;
    private Timestamp dateJoin;
    private Collection<AdminInfo> adminInfosById;
    private Collection<IdolFollowing> idolFollowingsById;
    private Collection<IdolFollowing> idolFollowingsById_0;
    private Collection<PlaylistInfo> playlistInfosById;
    private Collection<TopCoverIdol> topCoverIdolsById;
    private Collection<TopLipSyncIdol> topLipSyncIdolsById;
    private Collection<UserInfo> userInfosById = new LinkedHashSet<UserInfo>();
    private Collection<VideoInfo> videoInfosById;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (role != account.role) return false;
        if (state != account.state) return false;
        if (username != null ? !username.equals(account.username) : account.username != null) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;
        if (fullname != null ? !fullname.equals(account.fullname) : account.fullname != null) return false;
        if (dateJoin != null ? !dateJoin.equals(account.dateJoin) : account.dateJoin != null) return false;

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
        return result;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<AdminInfo> getAdminInfosById() {
        return adminInfosById;
    }

    public void setAdminInfosById(Collection<AdminInfo> adminInfosById) {
        this.adminInfosById = adminInfosById;
    }

    /**
     * Get Idols
     * @return
     */
    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<IdolFollowing> getIdolFollowingsById() {
        return idolFollowingsById;
    }

    public void setIdolFollowingsById(Collection<IdolFollowing> idolFollowingsById) {
        this.idolFollowingsById = idolFollowingsById;
    }

    /**
     * Get Fans
     * @return
     */
    @OneToMany(mappedBy = "accountByFollowedAccountId")
    public Collection<IdolFollowing> getIdolFollowingsById_0() {
        return idolFollowingsById_0;
    }

    public void setIdolFollowingsById_0(Collection<IdolFollowing> idolFollowingsById_0) {
        this.idolFollowingsById_0 = idolFollowingsById_0;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<PlaylistInfo> getPlaylistInfosById() {
        return playlistInfosById;
    }

    public void setPlaylistInfosById(Collection<PlaylistInfo> playlistInfosById) {
        this.playlistInfosById = playlistInfosById;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<TopCoverIdol> getTopCoverIdolsById() {
        return topCoverIdolsById;
    }

    public void setTopCoverIdolsById(Collection<TopCoverIdol> topCoverIdolsById) {
        this.topCoverIdolsById = topCoverIdolsById;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<TopLipSyncIdol> getTopLipSyncIdolsById() {
        return topLipSyncIdolsById;
    }

    public void setTopLipSyncIdolsById(Collection<TopLipSyncIdol> topLipSyncIdolsById) {
        this.topLipSyncIdolsById = topLipSyncIdolsById;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<UserInfo> getUserInfosById() {
        return userInfosById;
    }

    public void setUserInfosById(Collection<UserInfo> userInfosById) {
        this.userInfosById = userInfosById;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<VideoInfo> getVideoInfosById() {
        return videoInfosById;
    }

    public void setVideoInfosById(Collection<VideoInfo> videoInfosById) {
        this.videoInfosById = videoInfosById;
    }
}
