package com.clteam.repositories.api;

import com.clteam.dataobject.VideoInfoEntity;

import java.util.List;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public interface VideoRepository {

    VideoInfoEntity getVideoInfo(int videoId);

    boolean deleteVideo(int videoId);

    boolean updateVideo(VideoInfoEntity video);

    int insertVideo(VideoInfoEntity video);

    List<VideoInfoEntity> getAllVideo();


    List<VideoInfoEntity> getVideosByAccountId(int accountId, int limit);

    List<VideoInfoEntity> findTopVideoOfAccount(int accountId, int limit);

    List<VideoInfoEntity> getListVideoOfAccountByType(int accountId, int limit, int type, int currentVideoId);
}
