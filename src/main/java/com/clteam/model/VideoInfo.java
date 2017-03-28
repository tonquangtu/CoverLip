package com.clteam.model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Khanh Nguyen on 28/3/2017.
 */
@Entity
@Table(name = "video_info", schema = "coverlip", catalog = "")
public class VideoInfo {
    private int id;
    private int accountId;
    private String videoLink;
    private Integer videoThumbnailLink;
    private Time duration;
    private Timestamp createDate;
    private int numView;
    private int numLike;
    private int numComment;
    private byte state;
    private String description;
    private Collection<CoverInfo> coverInfosById;
    private Collection<CoverOfPlaylist> coverOfPlaylistsById;
    private Collection<CoverTop> coverTopsById;
    private Collection<HotCover> hotCoversById;
    private Collection<HotLipsync> hotLipsyncsById;
    private Collection<KaraokeInfo> karaokeInfosById;
    private Collection<LipsyncTemplateInfo> lipsyncTemplateInfosById;
    private Collection<NewCover> newCoversById;
    private Collection<NewLipsync> newLipsyncsById;
    private Collection<TempCountViewCover> tempCountViewCoversById;
    private Collection<TempCountViewLipsync> tempCountViewLipsyncsById;
    private Collection<TempNewCoverAdmin> tempNewCoverAdminsById;
    private Collection<TempNewLipsyncAdmin> tempNewLipsyncAdminsById;
    private Account accountByAccountId;

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
    @Column(name = "video_link")
    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    @Basic
    @Column(name = "video_thumbnail_link")
    public Integer getVideoThumbnailLink() {
        return videoThumbnailLink;
    }

    public void setVideoThumbnailLink(Integer videoThumbnailLink) {
        this.videoThumbnailLink = videoThumbnailLink;
    }

    @Basic
    @Column(name = "duration")
    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
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
    @Column(name = "num_view")
    public int getNumView() {
        return numView;
    }

    public void setNumView(int numView) {
        this.numView = numView;
    }

    @Basic
    @Column(name = "num_like")
    public int getNumLike() {
        return numLike;
    }

    public void setNumLike(int numLike) {
        this.numLike = numLike;
    }

    @Basic
    @Column(name = "num_comment")
    public int getNumComment() {
        return numComment;
    }

    public void setNumComment(int numComment) {
        this.numComment = numComment;
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
    @Column(name = "description")
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

        VideoInfo videoInfo = (VideoInfo) o;

        if (id != videoInfo.id) return false;
        if (accountId != videoInfo.accountId) return false;
        if (numView != videoInfo.numView) return false;
        if (numLike != videoInfo.numLike) return false;
        if (numComment != videoInfo.numComment) return false;
        if (state != videoInfo.state) return false;
        if (videoLink != null ? !videoLink.equals(videoInfo.videoLink) : videoInfo.videoLink != null) return false;
        if (videoThumbnailLink != null ? !videoThumbnailLink.equals(videoInfo.videoThumbnailLink) : videoInfo.videoThumbnailLink != null)
            return false;
        if (duration != null ? !duration.equals(videoInfo.duration) : videoInfo.duration != null) return false;
        if (createDate != null ? !createDate.equals(videoInfo.createDate) : videoInfo.createDate != null) return false;
        if (description != null ? !description.equals(videoInfo.description) : videoInfo.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + accountId;
        result = 31 * result + (videoLink != null ? videoLink.hashCode() : 0);
        result = 31 * result + (videoThumbnailLink != null ? videoThumbnailLink.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + numView;
        result = 31 * result + numLike;
        result = 31 * result + numComment;
        result = 31 * result + (int) state;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<CoverInfo> getCoverInfosById() {
        return coverInfosById;
    }

    public void setCoverInfosById(Collection<CoverInfo> coverInfosById) {
        this.coverInfosById = coverInfosById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<CoverOfPlaylist> getCoverOfPlaylistsById() {
        return coverOfPlaylistsById;
    }

    public void setCoverOfPlaylistsById(Collection<CoverOfPlaylist> coverOfPlaylistsById) {
        this.coverOfPlaylistsById = coverOfPlaylistsById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<CoverTop> getCoverTopsById() {
        return coverTopsById;
    }

    public void setCoverTopsById(Collection<CoverTop> coverTopsById) {
        this.coverTopsById = coverTopsById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<HotCover> getHotCoversById() {
        return hotCoversById;
    }

    public void setHotCoversById(Collection<HotCover> hotCoversById) {
        this.hotCoversById = hotCoversById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<HotLipsync> getHotLipsyncsById() {
        return hotLipsyncsById;
    }

    public void setHotLipsyncsById(Collection<HotLipsync> hotLipsyncsById) {
        this.hotLipsyncsById = hotLipsyncsById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<KaraokeInfo> getKaraokeInfosById() {
        return karaokeInfosById;
    }

    public void setKaraokeInfosById(Collection<KaraokeInfo> karaokeInfosById) {
        this.karaokeInfosById = karaokeInfosById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<LipsyncTemplateInfo> getLipsyncTemplateInfosById() {
        return lipsyncTemplateInfosById;
    }

    public void setLipsyncTemplateInfosById(Collection<LipsyncTemplateInfo> lipsyncTemplateInfosById) {
        this.lipsyncTemplateInfosById = lipsyncTemplateInfosById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<NewCover> getNewCoversById() {
        return newCoversById;
    }

    public void setNewCoversById(Collection<NewCover> newCoversById) {
        this.newCoversById = newCoversById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<NewLipsync> getNewLipsyncsById() {
        return newLipsyncsById;
    }

    public void setNewLipsyncsById(Collection<NewLipsync> newLipsyncsById) {
        this.newLipsyncsById = newLipsyncsById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<TempCountViewCover> getTempCountViewCoversById() {
        return tempCountViewCoversById;
    }

    public void setTempCountViewCoversById(Collection<TempCountViewCover> tempCountViewCoversById) {
        this.tempCountViewCoversById = tempCountViewCoversById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<TempCountViewLipsync> getTempCountViewLipsyncsById() {
        return tempCountViewLipsyncsById;
    }

    public void setTempCountViewLipsyncsById(Collection<TempCountViewLipsync> tempCountViewLipsyncsById) {
        this.tempCountViewLipsyncsById = tempCountViewLipsyncsById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<TempNewCoverAdmin> getTempNewCoverAdminsById() {
        return tempNewCoverAdminsById;
    }

    public void setTempNewCoverAdminsById(Collection<TempNewCoverAdmin> tempNewCoverAdminsById) {
        this.tempNewCoverAdminsById = tempNewCoverAdminsById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<TempNewLipsyncAdmin> getTempNewLipsyncAdminsById() {
        return tempNewLipsyncAdminsById;
    }

    public void setTempNewLipsyncAdminsById(Collection<TempNewLipsyncAdmin> tempNewLipsyncAdminsById) {
        this.tempNewLipsyncAdminsById = tempNewLipsyncAdminsById;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    public Account getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(Account accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }
}
