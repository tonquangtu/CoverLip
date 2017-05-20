package com.clteam.model;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.TopCoverIdolEntity;
import com.clteam.dataobject.TopLipSyncIdolEntity;
import com.clteam.dataobject.UserInfoEntity;

/**
 * Created by Dell on 30-Apr-17.
 */
public class TopIdol {

    private User user;

    private int topId;

    private int score;

    public TopIdol(){}
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

    public void copyData(TopCoverIdolEntity topCoverIdolEntity, UserInfoEntity userInfoEntity, AccountEntity accountEntity){

        topId = topCoverIdolEntity.getTopId();
        score = topCoverIdolEntity.getScore();

        user = new User();
        user.copyData(userInfoEntity, accountEntity);
    }

    public void copyData(TopLipSyncIdolEntity topLSIdolEntity, UserInfoEntity userInfoEntity, AccountEntity accountEntity){

        topId = topLSIdolEntity.getTopId();
        score = topLSIdolEntity.getScore();

        user = new User();
        user.copyData(userInfoEntity, accountEntity);
    }
}
