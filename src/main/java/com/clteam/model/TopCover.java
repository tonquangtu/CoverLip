package com.clteam.model;

/**
 * Created by Dell on 30-Apr-17.
 */
public class TopCover {

    private int topId;

    private Cover cover;

    private int numViewPeriod;

    public TopCover(int topId, Cover cover, int numViewPeriod) {
        this.topId = topId;
        this.cover = cover;
        this.numViewPeriod = numViewPeriod;
    }

    public int getTopId() {
        return topId;
    }

    public void setTopId(int topId) {
        this.topId = topId;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public int getNumViewPeriod() {
        return numViewPeriod;
    }

    public void setNumViewPeriod(int numViewPeriod) {
        this.numViewPeriod = numViewPeriod;
    }
}
