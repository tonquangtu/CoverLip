package com.clteam.model;

import com.clteam.dataobject.TopCoverIdolEntity;
import com.clteam.dataobject.UserInfoEntity;

/**
 * Created by Dell on 30-Apr-17.
 */
public class TopIdol {

    private User user;

    private int topId;

    private int score;

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

    public void copyData(TopCoverIdolEntity topCoverIdolEntity, UserInfoEntity userInfoEntity){

        topId = topCoverIdolEntity.getTopId();
        score = topCoverIdolEntity.getScore();

        user = new User();
        user.copyData(userInfoEntity, userInfoEntity.getAccountByAccountId());
    }
}
