package com.clteam.repositories.impl;

import com.clteam.dataobject.Account;
import com.clteam.dataobject.VideoInfo;
import com.clteam.repositories.api.VideoRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
@Repository
public class VideoRepositoryImpl implements VideoRepository {

    @Autowired
    private SessionFactory sessionFactory;
    public VideoInfo getVideoInfo(int videoId) {
        return (VideoInfo)sessionFactory.getCurrentSession().get(VideoInfo.class, videoId);
    }

    public boolean deleteVideo(int videoId) {
        return false;
    }

    public boolean updateVideo(VideoInfo video) {
        return false;
    }

    public boolean insertVideo(VideoInfo video) {
        return false;
    }

    public Set<Account> getAllVideo() {
        return null;
    }
}
