package com.clteam.repositories.impl;

import com.clteam.repositories.api.CoverRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
@Repository
@Transactional
public class CoverRepositoryImpl implements CoverRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public CoverInfo getCoverInfo(int coverId) {
        return (CoverInfo)sessionFactory.getCurrentSession().get(CoverInfo.class, coverId);
    }

    public CoverInfo getCoverInfoByVideoId(int videoId) {
        return null;
    }
}
