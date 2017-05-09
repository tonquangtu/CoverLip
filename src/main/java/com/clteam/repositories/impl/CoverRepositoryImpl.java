package com.clteam.repositories.impl;

import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.HotCoverEntity;
import com.clteam.repositories.api.CoverRepository;
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
public class CoverRepositoryImpl implements CoverRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public CoverInfoEntity getCoverInfo(int coverId) {
        return (CoverInfoEntity)sessionFactory.getCurrentSession().get(CoverInfoEntity.class, coverId);
    }

    public CoverInfoEntity getCoverInfoByVideoId(int videoId) {
        return null;
    }

    public List<HotCoverEntity> getAllHotCover(int limit) {

        return  sessionFactory.getCurrentSession().createQuery("from HotCoverEntity order by priority ASC ").list();
    }
}
