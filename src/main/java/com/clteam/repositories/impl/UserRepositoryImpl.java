package com.clteam.repositories.impl;

import com.clteam.dataobject.*;
import com.clteam.model.TopList;
import com.clteam.repositories.api.UserRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public UserInfoEntity getUserInfo(int userId) {
        return (UserInfoEntity)sessionFactory.getCurrentSession().get(UserInfoEntity.class, userId);
    }

    public UserInfoEntity getUserInfoByAccountId(int accountId) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserInfoEntity.class);
        criteria.add(Restrictions.eq("accountId", accountId));
        List<UserInfoEntity> list = criteria.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    public UserInfoEntity getUser(int accountId) {
        return null;
    }

    public boolean deleteUser(int accountId) {
        return false;
    }

    public boolean updateUser(UserInfoEntity user) {
        return false;
    }

    public boolean insertUser(UserInfoEntity user) {
        return false;
    }

    public List<UserInfoEntity> getAllUser() {
        return null;
    }

    public void indexTables() {

        try {
            Session session = sessionFactory.getCurrentSession();
            FullTextSession fullTextSession = Search.getFullTextSession(session);

            fullTextSession.createIndexer(CoverInfoEntity.class).startAndWait();

            fullTextSession.createIndexer(LipSyncTemplateInfoEntity.class).startAndWait();


//
//            fullTextSession
//                    .createIndexer(LipSyncTemplateInfoEntity.class, CoverInfoEntity.class)
//                    .batchSizeToLoadObjects( 25 )
//                    .cacheMode( CacheMode.IGNORE )
//                    .threadsToLoadObjects( 12 )
//                    .idFetchSize( 150 )
//                    .startAndWait();


        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TopLipSyncIdolEntity> getTopLipSyncIdols(int limit) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TopListEntity.class);
        criteria.add(Restrictions.eq("active", TopList.ACTIVE));
        criteria.add(Restrictions.eq("type", TopList.TOP_LIP_SYNC_IDOL));

        List<TopListEntity> topEntities =  criteria.list();
        if (topEntities != null && topEntities.size() > 0) {
            int topId  = topEntities.get(0).getId();

            criteria = sessionFactory.getCurrentSession().createCriteria(TopLipSyncIdolEntity.class);
            criteria.add(Restrictions.eq("topId", topId));
            criteria.addOrder(Order.desc("score"));
            if (limit > 0) {
                criteria.setMaxResults(limit);
            }

            return criteria.list();
        }

        return null;
    }

}
