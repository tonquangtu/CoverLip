package com.clteam.security.repository;

import com.clteam.model.Playlist;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Khanh Nguyen on 22/5/2017.
 */
@Repository
public class AdminPlaylistRepositoryImpl implements AdminPlaylistRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Query getQueryPlayListList() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select new " + Playlist.class.getName() +
                "(p)" +
                " from PlaylistInfoEntity p order by p.createDate desc");
    }

}
