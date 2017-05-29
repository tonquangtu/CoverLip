package com.clteam.repositories.impl;

import com.clteam.dataobject.VideoInfoEntity;
import com.clteam.repositories.api.VideoRepository;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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

        if (video != null) {
            Session session = sessionFactory.getCurrentSession();
            session.update(video);
            return true;
        }

        return false;
    }

    public int insertVideo(VideoInfoEntity video) {

        if (video == null) {
            return -1;
        }
        Session session = sessionFactory.getCurrentSession();
        return (Integer)session.save(video);

    }

    public List<VideoInfoEntity> getAllVideo() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from VideoInfoEntity");
        return query.list();
    }

    @Override
    public List<VideoInfoEntity> getVideosByAccountId(int accountId, int limit) {

        if (accountId < 0 || limit <= 0) {
            return null;
        }
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from VideoInfoEntity where accountId = :account_id");
        query.setParameter("account_id", accountId);
        query.setMaxResults(limit);

        return query.list();
    }


    @Override
    public List<VideoInfoEntity> findTopVideoOfAccount(int accountId, int limit) {

        if (accountId < 0 || limit <= 0) {
            return null;
        }

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(VideoInfoEntity.class);

        criteria.add(Restrictions.eq("accountId", accountId));
        criteria.addOrder(Order.desc("numView"));
        criteria.setMaxResults(limit);
        return criteria.list();
    }

    @Override
    public List<VideoInfoEntity> getListVideoOfAccountByType(int accountId, int limit, int type, int currentVideoId) {
        if(accountId<0||type<1||type>3){
            return null;
        }
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(VideoInfoEntity.class);
        criteria.add(Restrictions.eq("accountId", accountId));
        criteria.add(Restrictions.eq("type", type));
        if(currentVideoId!=-1) {
            criteria.add(Restrictions.lt("id", currentVideoId));
        }
        criteria.addOrder(Order.desc("id"));
        if(limit>0){
            criteria.setMaxResults(limit);
        }
        return criteria.list();
    }

}
