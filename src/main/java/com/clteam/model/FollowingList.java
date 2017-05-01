package com.clteam.model;

import java.util.List;

/**
 * Created by Dell on 30-Apr-17.
 */
public class FollowingList {

    public static final int IDOL_TYPE = 1;

    public static final int FAN_TYPE = 2;

    private int type;

    private List<Following> followings;

    public FollowingList(int type, List<Following> followings) {
        this.type = type;
        this.followings = followings;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Following> getFollowings() {
        return followings;
    }

    public void setFollowings(List<Following> followings) {
        this.followings = followings;
    }
}
