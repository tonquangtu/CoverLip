package com.clteam.repositories.impl;

import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.HotCoverEntity;
import com.clteam.dataobject.NewCoverEntity;
import com.clteam.repositories.api.CoverRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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

    public List<NewCoverEntity> getListNewCover(int limit) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(NewCoverEntity.class);
        List newCoverList = criteria.addOrder(Order.asc("priority")).setMaxResults(limit).list();
        return newCoverList;
    }


    public List<HotCoverEntity> getAllHotCover(int limit) {

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(HotCoverEntity.class);
        List hotCoverEntity = criteria.addOrder(Order.asc("priority")).list();
        return hotCoverEntity;
    }
}
