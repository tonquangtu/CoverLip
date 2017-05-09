package com.clteam.repositories.impl;

import com.clteam.dataobject.VideoInfoEntity;
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
    public VideoInfoEntity getVideoInfo(int videoId) {
        return (VideoInfoEntity)sessionFactory.getCurrentSession().get(VideoInfoEntity.class, videoId);
    }

    public boolean deleteVideo(int videoId) {
        return false;
    }

    public boolean updateVideo(VideoInfoEntity video) {
        return false;
    }

    public boolean insertVideo(VideoInfoEntity video) {
        return false;
    }

    public List<VideoInfoEntity> getAllVideo() {
        return null;
    }
}
