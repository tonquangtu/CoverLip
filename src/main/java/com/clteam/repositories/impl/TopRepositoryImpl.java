package com.clteam.repositories.impl;

import com.clteam.dataobject.TopCoverIdolEntity;
import com.clteam.dataobject.TopListEntity;
import com.clteam.repositories.api.TopRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
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

    @Override
    public TopListEntity getNewTop() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TopListEntity.class);
        List topListEntity = criteria.addOrder(Order.desc("id")).setMaxResults(1).list();
        return (TopListEntity) topListEntity.get(0);
    }

    public List<TopCoverIdolEntity> getListTopCoverIdols(int limit, int topId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TopCoverIdolEntity.class);
        List topCoverIdol = criteria.add(Restrictions.eq("topId", topId)).addOrder(Order.desc("score")).setMaxResults(limit).list();

        return topCoverIdol;
    }

    public int getMaxTopId(){

        int maxTopId = -1;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TopListEntity.class);

        List<TopListEntity> list = criteria.addOrder(Order.desc("id")).list();
        if (list != null){
            TopListEntity topListEntity = list.get(0);
            maxTopId = topListEntity.getId();
        }
        return maxTopId;
    }
}
