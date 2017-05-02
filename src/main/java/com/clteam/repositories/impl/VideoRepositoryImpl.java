package com.clteam.repositories.impl;

import com.clteam.dataobject.VideoInfoEntity;
import com.clteam.model.Cover;
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


    public VideoInfoEntity getVideoInfo(int videoId) {
        return null;
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

    public List<Cover> getAllNewCover() {
        return null;
    }
}
