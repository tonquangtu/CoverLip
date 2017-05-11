package com.clteam.dataobject;

import org.apache.solr.analysis.*;
import org.hibernate.search.annotations.*;

import javax.persistence.*;

/**
 * Created by Dell on 30-Apr-17.
 */
@Entity
@Table(name = "cover_info")
@Indexed
@AnalyzerDef(name = "customanalyzer",
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                @TokenFilterDef(factory = StopFilterFactory.class),
//                @TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = {
//                        @Parameter(name = "language", value = "English")
//                }),
                @TokenFilterDef(factory = ASCIIFoldingFilterFactory.class),
                @TokenFilterDef(factory = SnowballPorterFilterFactory.class)

        })
public class CoverInfoEntity {
    private int id;
    private int videoId;
    private String coverName;
    private String mp3Link;

    private VideoInfoEntity videoInfoByVideoId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "video_id")
    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    @Basic
    @Column(name = "cover_name")
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    @Analyzer(definition = "customanalyzer")
    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    @Basic
    @Column(name = "mp3_link", columnDefinition = "TEXT")
    public String getMp3Link() {
        return mp3Link;
    }

    public void setMp3Link(String mp3Link) {
        this.mp3Link = mp3Link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoverInfoEntity that = (CoverInfoEntity) o;

        if (id != that.id) return false;
        if (videoId != that.videoId) return false;
        if (coverName != null ? !coverName.equals(that.coverName) : that.coverName != null) return false;
        if (mp3Link != null ? !mp3Link.equals(that.mp3Link) : that.mp3Link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + videoId;
        result = 31 * result + (coverName != null ? coverName.hashCode() : 0);
        result = 31 * result + (mp3Link != null ? mp3Link.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "video_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public VideoInfoEntity getVideoInfoByVideoId() {
        return videoInfoByVideoId;
    }

    public void setVideoInfoByVideoId(VideoInfoEntity videoInfoByVideoId) {
        this.videoInfoByVideoId = videoInfoByVideoId;
    }
}
