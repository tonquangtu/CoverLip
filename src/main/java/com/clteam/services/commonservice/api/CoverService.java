package com.clteam.services.commonservice.api;

import com.clteam.model.Cover;
import com.clteam.model.Playlist;
import com.clteam.model.TopList;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by nguyenthanhtung on 18/05/2017.
 */
public interface CoverService {
    public List<Cover> getListNewCover(int limit);
    public List<Cover> getListHotCover(int limit);
    public List<Playlist> getListPlayListCover(int limit);
    TopList<Cover> getListTopCover(int numWeek);
    List<Cover> getListCoverOfUser(int accountId, int limit, int currentVideoId);
    List<Playlist> getListPlaylistOfUser(int accountId, int limit, int currentPlaylistId);
    public List<Cover> getListNewCover(int limit, int currentVideoId);
    int getNumWeekFromTimestamp(Timestamp timestamp);
    public Timestamp getNowTimestamp();
}
