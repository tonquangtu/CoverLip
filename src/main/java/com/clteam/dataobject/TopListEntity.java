package com.clteam.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Dell on 30-Apr-17.
 */
@Entity
@Table(name = "top_list")
public class TopListEntity {
    private int id;
    private int type;
    private int active;
    private Timestamp timeTopStart;
    private Timestamp timeEndStart;
    private String topDescription;
    private Collection<CoverTopEntity> coverTopsById;
    private Collection<TopCoverIdolEntity> topCoverIdolsById;
    private Collection<TopLipSyncIdolEntity> topLipSyncIdolsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "active", nullable = false)
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }


    @Basic
    @Column(name = "time_top_start")
    public Timestamp getTimeTopStart() {
        return timeTopStart;
    }

    public void setTimeTopStart(Timestamp timeTopStart) {
        this.timeTopStart = timeTopStart;
    }

    @Basic
    @Column(name = "time_end_start")
    public Timestamp getTimeEndStart() {
        return timeEndStart;
    }

    public void setTimeEndStart(Timestamp timeEndStart) {
        this.timeEndStart = timeEndStart;
    }

    @Basic
    @Column(name = "top_description",columnDefinition = "TEXT")
    public String getTopDescription() {
        return topDescription;
    }

    public void setTopDescription(String topDescription) {
        this.topDescription = topDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopListEntity that = (TopListEntity) o;

        if (id != that.id) return false;
        if (timeTopStart != null ? !timeTopStart.equals(that.timeTopStart) : that.timeTopStart != null) return false;
        if (timeEndStart != null ? !timeEndStart.equals(that.timeEndStart) : that.timeEndStart != null) return false;
        if (topDescription != null ? !topDescription.equals(that.topDescription) : that.topDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (timeTopStart != null ? timeTopStart.hashCode() : 0);
        result = 31 * result + (timeEndStart != null ? timeEndStart.hashCode() : 0);
        result = 31 * result + (topDescription != null ? topDescription.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "topListByTopId")
    public Collection<CoverTopEntity> getCoverTopsById() {
        return coverTopsById;
    }

    public void setCoverTopsById(Collection<CoverTopEntity> coverTopsById) {
        this.coverTopsById = coverTopsById;
    }

    @OneToMany(mappedBy = "topListByTopId")
    public Collection<TopCoverIdolEntity> getTopCoverIdolsById() {
        return topCoverIdolsById;
    }

    public void setTopCoverIdolsById(Collection<TopCoverIdolEntity> topCoverIdolsById) {
        this.topCoverIdolsById = topCoverIdolsById;
    }

    @OneToMany(mappedBy = "topListByTopId")
    public Collection<TopLipSyncIdolEntity> getTopLipSyncIdolsById() {
        return topLipSyncIdolsById;
    }

    public void setTopLipSyncIdolsById(Collection<TopLipSyncIdolEntity> topLipSyncIdolsById) {
        this.topLipSyncIdolsById = topLipSyncIdolsById;
    }
}
