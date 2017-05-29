package com.clteam.security.repository;

import com.clteam.model.Cover;
import com.clteam.model.Video;
import com.clteam.security.constant.SecurityConstant;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Khanh Nguyen on 22/5/2017.
 */
@Repository
public class AdminCoverRepositoryImpl implements AdminCoverRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Query getQueryCoverList() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select new " + Cover.class.getName() +
                        "(v)" +
                        " from VideoInfoEntity v where v.type=:type order by v.createDate desc")
                .setParameter("type", Video.COVER_TYPE);
    }

    @Override
    public Query getQueryCoverHotList() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from HotCoverEntity h order by h.priority desc");
    }

    @Override
    public Query getQueryCoverNewList() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from NewCoverEntity n order by n.priority desc");
    }
}
