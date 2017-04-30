package com.clteam.repositories.impl;

import com.clteam.dataobject.VideoInfo;
import com.clteam.repositories.api.VideoRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
@Repository
public class VideoRepositoryImpl implements VideoRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public VideoInfo getVideoInfo(long videoId) {
        VideoInfo video = null;
        try {

            video = (VideoInfo)sessionFactory.getCurrentSession().get(VideoInfo.class, videoId);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return video;
    }

    public boolean deleteVideo(long videoId) {
        return false;
    }

    public boolean updateVideo(VideoInfo video) {
        return false;
    }

    public boolean insertVideo(VideoInfo video) {
        return false;
    }

    public List<VideoInfo> getAllVideo() {
        return null;
    }
}
