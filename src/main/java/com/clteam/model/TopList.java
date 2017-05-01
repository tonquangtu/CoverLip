package com.clteam.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Dell on 30-Apr-17.
 */
public class TopList<E> {

    private int id;

    private Timestamp timeTopStart;

    private Timestamp timeEndStart;

    private String topDescription;

    List<E> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimeTopStart() {
        return timeTopStart;
    }

    public void setTimeTopStart(Timestamp timeTopStart) {
        this.timeTopStart = timeTopStart;
    }

    public Timestamp getTimeEndStart() {
        return timeEndStart;
    }

    public void setTimeEndStart(Timestamp timeEndStart) {
        this.timeEndStart = timeEndStart;
    }

    public String getTopDescription() {
        return topDescription;
    }

    public void setTopDescription(String topDescription) {
        this.topDescription = topDescription;
    }

    public List<E> getItems() {
        return items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }
}
