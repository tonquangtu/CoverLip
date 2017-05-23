package com.clteam.repositories.impl;

import com.clteam.dataobject.*;
import com.clteam.repositories.api.TopRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.service.spi.SessionFactoryServiceInitiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Dell on 28-Apr-17.
 */
@Repository
@Transactional
public class TopRepositoryImpl implements TopRepository {

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
    public TopListEntity getTopList(int type, int numWeek) {

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TopListEntity.class);
        criteria.add(Restrictions.ge("type", type));
        if (numWeek > 0) {
            List<TopListEntity> topListEntities = criteria.list();
            if (topListEntities.size() >= numWeek)
                return topListEntities.get(numWeek - 1);
        }
        criteria.add(Restrictions.eq("active", 1));
        return (TopListEntity) criteria.list().get(0);
    }

    public List<TopCoverIdolEntity> getListTopCoverIdols(int limit, int topId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TopCoverIdolEntity.class);
        List topCoverIdol = criteria.add(Restrictions.eq("topId", topId)).addOrder(Order.desc("score")).setMaxResults(limit).list();

        return topCoverIdol;
    }

    public int getMaxTopId() {

        int maxTopId = -1;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TopListEntity.class);

        List<TopListEntity> list = criteria.addOrder(Order.desc("id")).list();
        if (list != null) {
            TopListEntity topListEntity = list.get(0);
            maxTopId = topListEntity.getId();
        }
        return maxTopId;
    }

    public int getNumWeekFromTimestamp(int type, Timestamp timestamp) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TopListEntity.class);
        criteria.add(Restrictions.ge("type", type));
        List<TopListEntity> topListEntities = criteria.list();
        int i = 0;
        if (timestamp != null) {
            for (TopListEntity topListEntity : topListEntities) {
                i++;
                if (timestamp.after(topListEntity.getTimeTopStart()) && timestamp.before(topListEntity.getTimeEndStart())) {
                    return i;
                }
            }
        }
        i = 0;
        for (TopListEntity topListEntity : topListEntities) {
            i++;
            if (topListEntity.getActive() == 1) {
                return i;
            }
        }

        return 0;
    }

    @Override
    public TopListEntity getNewTop() {
        return null;
    }

    public List<TopLipSyncIdolEntity> getListTopLipSyncIdols(int limit, int topId){

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TopLipSyncIdolEntity.class);
        List topLipSyncIdol = criteria.add(Restrictions.eq("topId", topId)).addOrder(Order.desc("score")).setMaxResults(limit).list();

        return topLipSyncIdol;
    }

    @Override
    public int setFollowIdol(int acoundId, int topId, Timestamp timestampFollow){
        Session session = sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(IdolFollowingEntity.class);
        SimpleExpression simpleExpression1 =  Restrictions.eq("accountId", acoundId);
        SimpleExpression simpleExpression2 =  Restrictions.eq("followedAccountId", topId);
        List<IdolFollowingEntity> idolFollowingEntities = criteria.add(Restrictions.and(simpleExpression1, simpleExpression2)).list();
        if (idolFollowingEntities != null && idolFollowingEntities.size() > 0){
            return 0;
        }

        IdolFollowingEntity topLipSyncIdolEntity = new IdolFollowingEntity();
        topLipSyncIdolEntity.setAccountId(acoundId);
        topLipSyncIdolEntity.setFollowedAccountId(topId);
        topLipSyncIdolEntity.setTimeStartFollow(timestampFollow);

        session.save(topLipSyncIdolEntity);
        changeNumFollow(topId, 0);
        return 1;
    }

    public int changeNumFollow(int followId, int statusFollow){

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(UserInfoEntity.class);

        List<UserInfoEntity> userInfoEntities = criteria.add(Restrictions.eq("accountId", followId)).list();
        if (userInfoEntities != null && userInfoEntities.size() > 0){
            UserInfoEntity userInfoEntity = userInfoEntities.get(0);
            int numFollow = userInfoEntity.getNumHaveFollowed();

            if (statusFollow == 0){
                userInfoEntity.setNumHaveFollowed(numFollow + 1);
            }
            else {
                userInfoEntity.setNumHaveFollowed(numFollow - 1);
            }

        }

        return 1;
    }

    @Override
    public int unFollowIdol(int acoundId, int topId) {

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(IdolFollowingEntity.class);
        //IdolFollowingEntity idolFollowingEntity =

        SimpleExpression simpleExpression1 =  Restrictions.eq("accountId", acoundId);
        SimpleExpression simpleExpression2 =  Restrictions.eq("followedAccountId", topId);
        List<IdolFollowingEntity> idolFollowingEntities = criteria.add(Restrictions.and(simpleExpression1, simpleExpression2)).list();
        if (idolFollowingEntities != null && idolFollowingEntities.size() > 0){
            for (IdolFollowingEntity idolFollowingEntity : idolFollowingEntities){
                session.delete(idolFollowingEntity);
            }
            changeNumFollow(topId, 1);
            return 1;
        }
        else{
            return 0;
        }

    }


}
