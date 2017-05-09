package com.clteam.repositories.impl;

import com.clteam.dataobject.TopCoverIdolEntity;
import com.clteam.dataobject.TopListEntity;
import com.clteam.model.TopIdol;
import com.clteam.repositories.api.TopRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dell on 28-Apr-17.
 */
@Repository
@Transactional
public class TopRepositoryImpl implements TopRepository{

    @Autowired
    private SessionFactory sessionFactory;


    public TopListEntity getTop(int topId) {
        return null;
    }

    public boolean deleteTop(int topId) {
        return false;
    }

    public boolean updateTop(TopListEntity top) {
        return false;
    }

    public boolean insertTop(TopListEntity top) {
        return false;
    }

    public List<TopListEntity> getAllTop() {
        return null;
    }

    public List<TopCoverIdolEntity> getListTopCoverIdols(int limit) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TopCoverIdolEntity.class);
        List topCoverIdol = criteria.addOrder(Order.desc("score")).setMaxResults(limit).list();

        return topCoverIdol;
    }
}
