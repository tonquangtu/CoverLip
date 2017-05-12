package com.clteam.model;

import java.util.List;

/**
 * Created by Dell on 05-May-17.
 */
public class CoverWrapper implements Comparable<CoverWrapper> {

    private String recommendationClass;

    private Cover cover;

    private User user;

    private List<Integer> playlistId;

    private boolean isHot;

    private float similarity;

    public CoverWrapper() {}


    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(List<Integer> playlistId) {
        this.playlistId = playlistId;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public float getSimilarity() {
        return similarity;
    }

    public void setSimilarity(float similarity) {
        this.similarity = similarity;
    }

    @Override
    public int compareTo(CoverWrapper o) {

        if (o.getSimilarity() > similarity) {
            return 1;
        } else if (o.getSimilarity() < similarity) {
            return -1;
        }
        return 0;
    }


    public static boolean isExitsItem(CoverWrapper checkItem, List<CoverWrapper> list) {

        if (checkItem == null || list == null || list.size() <= 0) {
            return false;
        }
        boolean isExists = false;
        try {
            int checkItemId = checkItem.getCover().getVideo().getId();
            for (CoverWrapper item : list) {

                if (item.getCover().getVideo().getId() == checkItemId) {
                    isExists = true;
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("IsExits: " + isExists);
        return isExists;
    }

    public String getRecommendationClass() {
        return recommendationClass;
    }

    public void setRecommendationClass(String recommendationClass) {
        this.recommendationClass = recommendationClass;
    }
}
