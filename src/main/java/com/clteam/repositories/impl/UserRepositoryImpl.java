package com.clteam.repositories.impl;

import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.IdolFollowingEntity;
import com.clteam.dataobject.LipSyncTemplateInfoEntity;
import com.clteam.dataobject.UserInfoEntity;
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
        return (UserInfoEntity)sessionFactory.getCurrentSession().createQuery("from UserInfoEntity where accountId="+accountId).list().get(0);
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
    public List<IdolFollowingEntity> getListIdolOfUser(int accountId, int limit, int currentIdolAccountId) {
        if(accountId<0) return null;
        int currentIdolFollowingId = -1;
        if(currentIdolAccountId>0){
            currentIdolFollowingId = getIdolFollowingIdFromAccountId(accountId, currentIdolAccountId);
        }
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(IdolFollowingEntity.class);
        criteria.add(Restrictions.eq("accountId", accountId));
        if(currentIdolFollowingId>0){
            criteria.add(Restrictions.lt("id", currentIdolFollowingId));
        }
        criteria.addOrder(Order.desc("id"));
        if(limit>0){
            criteria.setMaxResults(limit);
        }

        return criteria.list();
    }

    @Override
    public List<IdolFollowingEntity> getListFanOfUser(int accountId, int limit, int currentFanAccountId) {
        if(accountId<0) return null;
        int currentIdolFollowingId = -1;
        if(currentFanAccountId>0){
            currentIdolFollowingId = getIdolFollowingIdFromAccountId(currentFanAccountId, accountId);
        }
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(IdolFollowingEntity.class);
        criteria.add(Restrictions.eq("followedAccountId", accountId));
        if(currentIdolFollowingId>0){
            criteria.add(Restrictions.lt("id", currentIdolFollowingId));
        }
        criteria.addOrder(Order.desc("id"));
        if(limit>0){
            criteria.setMaxResults(limit);
        }

        return criteria.list();
    }

    @Override
    public int getIdolFollowingIdFromAccountId(int accountId, int followedAccountId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(IdolFollowingEntity.class);
        criteria.add(Restrictions.eq("accountId", accountId));
        criteria.add(Restrictions.eq("followedAccountId", followedAccountId));
        if(criteria.list()!=null && criteria.list().size()>0){
            IdolFollowingEntity idolFollowingEntity = (IdolFollowingEntity) criteria.list().get(0);
            return idolFollowingEntity.getId();
        }
        return 0;
    }
}
