package com.clteam.model;

import java.util.List;

/**
 * Created by Dell on 24-May-17.
 */
public class SearchData {

    public static int BEST_VIDEO_SEARCH = 1;

    public static int BEST_ACC_SEARCH = 2;

    private int bestSearchType;

    private int totalVideo;

    private int totalAccount;

    private Account bestAccountSearch;

    private VideoWrapper bestVideoSearch;

    private List<VideoWrapper> videoSearchList;

    private List<Account> accountSearchList;

    public int getBestSearchType() {
        return bestSearchType;
    }

    public void setBestSearchType(int bestSearchType) {
        this.bestSearchType = bestSearchType;
    }

    public Account getBestAccountSearch() {
        return bestAccountSearch;
    }

    public void setBestAccountSearch(Account bestAccountSearch) {
        this.bestAccountSearch = bestAccountSearch;
    }

    public VideoWrapper getBestVideoSearch() {
        return bestVideoSearch;
    }

    public void setBestVideoSearch(VideoWrapper bestVideoSearch) {
        this.bestVideoSearch = bestVideoSearch;
    }

    public List<VideoWrapper> getVideoSearchList() {
        return videoSearchList;
    }

    public void setVideoSearchList(List<VideoWrapper> videoSearchList) {
        this.videoSearchList = videoSearchList;
    }

    public List<Account> getAccountSearchList() {
        return accountSearchList;
    }

    public void setAccountSearchList(List<Account> accountSearchList) {
        this.accountSearchList = accountSearchList;
    }

    public int getTotalVideo() {
        return totalVideo;
    }

    public void setTotalVideo(int totalVideo) {
        this.totalVideo = totalVideo;
    }

    public int getTotalAccount() {
        return totalAccount;
    }

    public void setTotalAccount(int totalAccount) {
        this.totalAccount = totalAccount;
    }
}
