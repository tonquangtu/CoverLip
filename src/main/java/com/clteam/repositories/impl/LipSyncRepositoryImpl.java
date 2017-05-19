package com.clteam.repositories.impl;

import com.clteam.dataobject.HotLipSyncEntity;
import com.clteam.dataobject.LipSyncInfoEntity;
import com.clteam.dataobject.LipSyncTemplateInfoEntity;
import com.clteam.repositories.api.LipSyncRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dell on 28-Apr-17.
 */
@Repository
@Transactional
public class LipSyncRepositoryImpl  implements LipSyncRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<LipSyncTemplateInfoEntity> searchLipSyncByName(String name, int limit) {
        System.out.println("Input: " + name);
        Session session = sessionFactory.getCurrentSession();

        FullTextSession fullTextSession = Search.getFullTextSession(session);

        QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(LipSyncTemplateInfoEntity.class).get();
        org.apache.lucene.search.Query query = qb
                .keyword().onFields("lipSyncTemplateName") // Chỉ định tìm theo cột nào
                .matching(name)
                .createQuery();

        org.hibernate.Query hibQuery =
                fullTextSession.createFullTextQuery(query, LipSyncTemplateInfoEntity.class);

        hibQuery.setMaxResults(limit);
        List<LipSyncTemplateInfoEntity> results = hibQuery.list();
        return results;
    }

    @Override
    public int insertTemplate(LipSyncTemplateInfoEntity templateEntity) {

        if (templateEntity == null) {
            return -1;
        }
        Session session = sessionFactory.getCurrentSession();
        int rowId = (Integer)session.save(templateEntity);
        return rowId;
    }

    @Override
    public int insertLipSync(LipSyncInfoEntity lipSyncEntity) {

        if (lipSyncEntity == null) {
            return -1;
        }
        Session session = sessionFactory.getCurrentSession();
        int rowId = (Integer)session.save(lipSyncEntity);
        return rowId;
    }

    @Override
    public LipSyncInfoEntity getLipSync(int videoId) {

        LipSyncInfoEntity lipSyncEntity = null;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(LipSyncInfoEntity.class);
        criteria.add(Restrictions.eq("videoId", videoId));
        List<LipSyncInfoEntity> list  = criteria.list();
        if (list != null && list.size() > 0) {
            lipSyncEntity = list.get(0);
        }

        return lipSyncEntity;
    }

    @Override
    public LipSyncTemplateInfoEntity getLipSyncTemplate(int videoId) {

        LipSyncTemplateInfoEntity templateEntity = null;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(LipSyncInfoEntity.class);
        criteria.add(Restrictions.eq("videoId", videoId));
        List<LipSyncTemplateInfoEntity> list  = criteria.list();
        if (list != null && list.size() > 0) {
            templateEntity = list.get(0);
        }

        return templateEntity;
    }

    @Override
    public List<LipSyncInfoEntity> findTopLipSyncOfAccount(int accountId, int limit) {

        if (accountId <= 0 && limit <= 0) {
            return null;
        }

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(LipSyncInfoEntity.class, "lipSync");
        criteria.createAlias("lipSync.videoInfoByVideoId", "video");
        criteria.add(Restrictions.eq("video.accountId", accountId));
        criteria.addOrder(Order.desc("video.numView"));
        criteria.setMaxResults(limit);

        return criteria.list();
    }

    @Override
    public List<HotLipSyncEntity> getLimitHotLipSync(int limit) {

        if (limit <= 0) {
            return null;
        }
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(HotLipSyncEntity.class);
        criteria.setMaxResults(limit);
        criteria.addOrder(Order.desc("priority"));
        criteria.setMaxResults(limit);
        return criteria.list();
    }

    @Override
    public HotLipSyncEntity findHotLipSync(int videoId) {

        HotLipSyncEntity hotLipSyncEntity = null;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(HotLipSyncEntity.class);
        criteria.add(Restrictions.eq("videoId", videoId));

        List<HotLipSyncEntity> list = criteria.list();
        if (list != null && list.size() > 0) {
            hotLipSyncEntity =  list.get(0);
        }
        return hotLipSyncEntity;
    }

    public List<LipSyncInfoEntity> getListLipSyncOfUser(int accountId, int limit, int currentVideoId){
        if (accountId <= 0) {
            return null;
        }

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(LipSyncInfoEntity.class, "lipSync");
        criteria.createAlias("lipSync.videoInfoByVideoId", "video");
        criteria.add(Restrictions.eq("video.accountId", accountId));
        if(currentVideoId>-1){
            criteria.add(Restrictions.lt("lipSync.videoId", currentVideoId));
        }
        criteria.addOrder(Order.desc("video.id"));
        if(limit>0){
            criteria.setMaxResults(limit);
        }

        return criteria.list();
    }
}
