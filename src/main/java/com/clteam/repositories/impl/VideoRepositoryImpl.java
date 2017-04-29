package com.clteam.repositories.impl;

import com.clteam.dataobject.HotCover;
import com.clteam.dataobject.NewCover;
import com.clteam.dataobject.VideoInfo;
import com.clteam.repositories.api.VideoRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
@Repository
@Transactional
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

    public List<VideoInfo> getAllVideo() {
        return null;
    }

    public List<NewCover> getAllNewCover() {
        return sessionFactory.getCurrentSession().createQuery("from NewCover order by priority asc").list();
    }

    public List<HotCover> getAllHotCover() {
        return null;
    }
}
