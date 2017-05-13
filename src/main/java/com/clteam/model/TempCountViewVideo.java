package com.clteam.model;

/**
 * Created by Dell on 30-Apr-17.
 */
public class TempCountViewVideo<E> {

    private E video;

    private int numView;

    private int week;

    private int year;

    public E getVideo() {
        return video;
    }

    public void setVideo(E video) {
        this.video = video;
    }

    public int getNumView() {
        return numView;
    }

    public void setNumView(int numView) {
        this.numView = numView;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
