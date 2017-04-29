package com.clteam.repositories.api;

import com.clteam.dataobject.HotCover;
import com.clteam.dataobject.NewCover;
import com.clteam.dataobject.VideoInfo;

import java.util.List;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public interface VideoRepository {

    VideoInfo getVideoInfo(int videoId);

    boolean deleteVideo(int videoId);

    boolean updateVideo(VideoInfo video);

    boolean insertVideo(VideoInfo video);

    List<VideoInfo> getAllVideo();

    List<NewCover> getAllNewCover();

    List<HotCover> getAllHotCover();


}
