package com.clteam.model;

/**
 * Created by Dell on 10-May-17.
 */
public class LipSyncWrapper implements Comparable<LipSyncWrapper> {

    private String recommendationClass;

    private LipSync lipSync;

    private User user;

    private boolean isHot;

    private float similarity;

    public String getRecommendationClass() {
        return recommendationClass;
    }

    public void setRecommendationClass(String recommendationClass) {
        this.recommendationClass = recommendationClass;
    }

    public LipSync getLipSync() {
        return lipSync;
    }

    public void setLipSync(LipSync lipSync) {
        this.lipSync = lipSync;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    public int compareTo(LipSyncWrapper o) {

        if (o.getSimilarity() > similarity) {
            return 1;
        } else if (o.getSimilarity() < similarity) {
            return -1;
        }
        return 0;

    }


}
