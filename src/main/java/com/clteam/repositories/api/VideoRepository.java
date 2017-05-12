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

    boolean insertVideo(VideoInfoEntity video);

    List<VideoInfoEntity> getAllVideo();


}
