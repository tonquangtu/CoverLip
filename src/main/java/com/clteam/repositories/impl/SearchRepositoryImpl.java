package com.clteam.repositories.impl;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.VideoInfoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dell on 23-May-17.
 */
@Repository
@Transactional
public class SearchRepositoryImpl  {

    @Autowired
    SessionFactory sessionFactory;


    public List<VideoInfoEntity> searchCoversByUser2(String searchString, int limit) {

        Session session = sessionFactory.getCurrentSession();

        FullTextSession fullTextSession = Search.getFullTextSession(session);

        QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(VideoInfoEntity.class).get();

        org.apache.lucene.search.Query query = qb
                .keyword().onFields("accountByAccountId.fullname") // Chỉ định tìm theo cột nào
                .matching(searchString)
                .createQuery();

        FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(query, VideoInfoEntity.class);
        fullTextQuery.enableFullTextFilter("videoFilter");
//        fullTextQuery.enableFullTextFilter("videoFilter").setParameter("type", 1);


        fullTextQuery.setMaxResults(limit);
        List<VideoInfoEntity> results = fullTextQuery.list();
        System.out.println("Tim theo user: " + results.size());
        return results;
    }


    public List<CoverInfoEntity> searchCoversByName(String name, int limit){

        Session session = sessionFactory.getCurrentSession();
        FullTextSession fullTextSession = Search.getFullTextSession(session);

        QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(CoverInfoEntity.class).get();
        org.apache.lucene.search.Query query = qb
                .keyword().onFields("coverName") // Chỉ định tìm theo cột nào
                .matching(name)
                .createQuery();

        org.hibernate.Query hibQuery =
                fullTextSession.createFullTextQuery(query, CoverInfoEntity.class);

        hibQuery.setMaxResults(limit);
        List<CoverInfoEntity> results = hibQuery.list();
        return results;

    }

    public List<AccountEntity> searchUsers(String searchString, int limit) {

        Session session = sessionFactory.getCurrentSession();
        FullTextSession fullTextSession = Search.getFullTextSession(session);

        QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(AccountEntity.class).get();
        org.apache.lucene.search.Query query = qb
                .keyword().onFields("fullname") // Chỉ định tìm theo cột nào
                .matching(searchString)
                .createQuery();

        FullTextQuery fullTextQuery =
                fullTextSession.createFullTextQuery(query, AccountEntity.class);
//        fullTextQuery.enableFullTextFilter("accountFilter");

        fullTextQuery.setMaxResults(limit);
        List<AccountEntity> results = fullTextQuery.list();
        return results;
    }

    public List<CoverInfoEntity> searchCoversByUser(String searchString, int limit) {

        Session session = sessionFactory.getCurrentSession();

        FullTextSession fullTextSession = Search.getFullTextSession(session);

        QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(CoverInfoEntity.class).get();

        org.apache.lucene.search.Query query = qb
                .keyword().onFields("videoInfoByVideoId.accountByAccountId.fullname") // Chỉ định tìm theo cột nào
                .matching(searchString)
                .createQuery();

        FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(query, CoverInfoEntity.class);
//        fullTextQuery.enableFullTextFilter("videoFilter");
//        fullTextQuery.enableFullTextFilter("videoFilter").setParameter("type", 1);

        fullTextQuery.setMaxResults(limit);
        List<CoverInfoEntity> results = fullTextQuery.list();
        System.out.println("Tim theo user: " + results.size());
        return results;
    }



}

//"coverInfosById.coverName", "accountByAccountId.fullname"
