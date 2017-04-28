package com.clteam.repositories.api;

import com.clteam.dataobject.Account;
import com.clteam.dataobject.VideoInfo;

import java.util.Set;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public interface VideoRepository {

    VideoInfo getVideoInfo(int videoId);

    boolean deleteVideo(int videoId);

    boolean updateVideo(VideoInfo video);

    boolean insertVideo(VideoInfo video);

    Set<Account> getAllVideo();


}
