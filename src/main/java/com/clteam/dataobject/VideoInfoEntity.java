package com.clteam.dataobject;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Dell on 30-Apr-17.
 */
@Entity
@Table(name = "video_info")
public class VideoInfoEntity {
    private int id;
    private int accountId;
    private String videoLink;
    private String videoThumbnailLink;
    private Time duration;
    private Timestamp createDate;
    private int numView;
    private int numLike;
    private int numComment;
    private byte state;
    private String description;
    private int type;

    private Collection<CoverInfoEntity> coverInfosById;
    private Collection<CoverOfPlaylistEntity> coverOfPlaylistsById;
    private Collection<CoverTopEntity> coverTopsById;
    private Collection<HotCoverEntity> hotCoversById;
    private Collection<HotLipSyncEntity> hotLipSyncsById;
    private Collection<KaraokeInfoEntity> karaokeInfosById;
    private Collection<LipSyncInfoEntity> lipSyncInfosById;
    private Collection<LipSyncTemplateInfoEntity> lipSyncTemplateInfosById;
    private Collection<NewCoverEntity> newCoversById;
    private Collection<NewLipsyncEntity> newLipsyncsById;
    private Collection<TempCountViewCoverEntity> tempCountViewCoversById;
    private Collection<TempCountViewLipSyncEntity> tempCountViewLipSyncsById;
    private Collection<TempNewCoverAdminEntity> tempNewCoverAdminsById;
    private Collection<TempNewLipSyncAdminEntity> tempNewLipSyncAdminsById;
    private AccountEntity accountByAccountId;

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
    @Column(name = "account_id")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "video_link", columnDefinition = "TEXT")
    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    @Basic
    @Column(name = "video_thumbnail_link", columnDefinition = "TEXT")
    public String getVideoThumbnailLink() {
        return videoThumbnailLink;
    }

    public void setVideoThumbnailLink(String videoThumbnailLink) {
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
    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name="type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoInfoEntity that = (VideoInfoEntity) o;

        if (id != that.id) return false;
        if (accountId != that.accountId) return false;
        if (numView != that.numView) return false;
        if (numLike != that.numLike) return false;
        if (numComment != that.numComment) return false;
        if (state != that.state) return false;
        if (videoLink != null ? !videoLink.equals(that.videoLink) : that.videoLink != null) return false;
        if (videoThumbnailLink != null ? !videoThumbnailLink.equals(that.videoThumbnailLink) : that.videoThumbnailLink != null)
            return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

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
    public Collection<CoverInfoEntity> getCoverInfosById() {
        return coverInfosById;
    }

    public void setCoverInfosById(Collection<CoverInfoEntity> coverInfosById) {
        this.coverInfosById = coverInfosById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<CoverOfPlaylistEntity> getCoverOfPlaylistsById() {
        return coverOfPlaylistsById;
    }

    public void setCoverOfPlaylistsById(Collection<CoverOfPlaylistEntity> coverOfPlaylistsById) {
        this.coverOfPlaylistsById = coverOfPlaylistsById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<CoverTopEntity> getCoverTopsById() {
        return coverTopsById;
    }

    public void setCoverTopsById(Collection<CoverTopEntity> coverTopsById) {
        this.coverTopsById = coverTopsById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<HotCoverEntity> getHotCoversById() {
        return hotCoversById;
    }

    public void setHotCoversById(Collection<HotCoverEntity> hotCoversById) {
        this.hotCoversById = hotCoversById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<HotLipSyncEntity> getHotLipSyncsById() {
        return hotLipSyncsById;
    }

    public void setHotLipSyncsById(Collection<HotLipSyncEntity> hotLipSyncsById) {
        this.hotLipSyncsById = hotLipSyncsById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<KaraokeInfoEntity> getKaraokeInfosById() {
        return karaokeInfosById;
    }

    public void setKaraokeInfosById(Collection<KaraokeInfoEntity> karaokeInfosById) {
        this.karaokeInfosById = karaokeInfosById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<LipSyncInfoEntity> getLipSyncInfosById() {
        return lipSyncInfosById;
    }

    public void setLipSyncInfosById(Collection<LipSyncInfoEntity> lipSyncInfosById) {
        this.lipSyncInfosById = lipSyncInfosById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<LipSyncTemplateInfoEntity> getLipSyncTemplateInfosById() {
        return lipSyncTemplateInfosById;
    }

    public void setLipSyncTemplateInfosById(Collection<LipSyncTemplateInfoEntity> lipSyncTemplateInfosById) {
        this.lipSyncTemplateInfosById = lipSyncTemplateInfosById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<NewCoverEntity> getNewCoversById() {
        return newCoversById;
    }

    public void setNewCoversById(Collection<NewCoverEntity> newCoversById) {
        this.newCoversById = newCoversById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<NewLipsyncEntity> getNewLipsyncsById() {
        return newLipsyncsById;
    }

    public void setNewLipsyncsById(Collection<NewLipsyncEntity> newLipsyncsById) {
        this.newLipsyncsById = newLipsyncsById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<TempCountViewCoverEntity> getTempCountViewCoversById() {
        return tempCountViewCoversById;
    }

    public void setTempCountViewCoversById(Collection<TempCountViewCoverEntity> tempCountViewCoversById) {
        this.tempCountViewCoversById = tempCountViewCoversById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<TempCountViewLipSyncEntity> getTempCountViewLipSyncsById() {
        return tempCountViewLipSyncsById;
    }

    public void setTempCountViewLipSyncsById(Collection<TempCountViewLipSyncEntity> tempCountViewLipSyncsById) {
        this.tempCountViewLipSyncsById = tempCountViewLipSyncsById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<TempNewCoverAdminEntity> getTempNewCoverAdminsById() {
        return tempNewCoverAdminsById;
    }

    public void setTempNewCoverAdminsById(Collection<TempNewCoverAdminEntity> tempNewCoverAdminsById) {
        this.tempNewCoverAdminsById = tempNewCoverAdminsById;
    }

    @OneToMany(mappedBy = "videoInfoByVideoId")
    public Collection<TempNewLipSyncAdminEntity> getTempNewLipSyncAdminsById() {
        return tempNewLipSyncAdminsById;
    }

    public void setTempNewLipSyncAdminsById(Collection<TempNewLipSyncAdminEntity> tempNewLipSyncAdminsById) {
        this.tempNewLipSyncAdminsById = tempNewLipSyncAdminsById;
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
