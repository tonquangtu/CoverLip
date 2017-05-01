package com.clteam.model;

/**
 * Created by Dell on 30-Apr-17.
 */
public class TopIdol {

    private User user;

    private int topId;

    private int score;

    public TopIdol(User user, int topId, int score) {
        this.user = user;
        this.topId = topId;
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTopId() {
        return topId;
    }

    public void setTopId(int topId) {
        this.topId = topId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
