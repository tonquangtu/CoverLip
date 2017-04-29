package com.clteam.dataobject;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Dell on 28-Apr-17.
 */
@Entity
@Table(name = "top_list")
public class TopList {
    private int id;
    private Timestamp timeTopStart;
    private Timestamp timeEndStart;
    private Date topDescription;
    private Collection<CoverTop> coverTopsById;
    private Collection<TopCoverIdol> topCoverIdolsById;
    private Collection<TopLipSyncIdol> topLipSyncIdolsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "top_description")
    public Date getTopDescription() {
        return topDescription;
    }

    public void setTopDescription(Date topDescription) {
        this.topDescription = topDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopList topList = (TopList) o;

        if (id != topList.id) return false;
        if (timeTopStart != null ? !timeTopStart.equals(topList.timeTopStart) : topList.timeTopStart != null)
            return false;
        if (timeEndStart != null ? !timeEndStart.equals(topList.timeEndStart) : topList.timeEndStart != null)
            return false;
        if (topDescription != null ? !topDescription.equals(topList.topDescription) : topList.topDescription != null)
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
    public Collection<CoverTop> getCoverTopsById() {
        return coverTopsById;
    }

    public void setCoverTopsById(Collection<CoverTop> coverTopsById) {
        this.coverTopsById = coverTopsById;
    }

    @OneToMany(mappedBy = "topListByTopId")
    public Collection<TopCoverIdol> getTopCoverIdolsById() {
        return topCoverIdolsById;
    }

    public void setTopCoverIdolsById(Collection<TopCoverIdol> topCoverIdolsById) {
        this.topCoverIdolsById = topCoverIdolsById;
    }

    @OneToMany(mappedBy = "topListByTopId")
    public Collection<TopLipSyncIdol> getTopLipSyncIdolsById() {
        return topLipSyncIdolsById;
    }

    public void setTopLipSyncIdolsById(Collection<TopLipSyncIdol> topLipSyncIdolsById) {
        this.topLipSyncIdolsById = topLipSyncIdolsById;
    }
}
