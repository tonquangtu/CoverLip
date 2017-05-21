package com.clteam.repositories.impl;

import com.clteam.dataobject.PlaylistInfoEntity;
import com.clteam.repositories.api.PlaylistRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dell on 28-Apr-17.
 */
@Repository
@Transactional
public class PlaylistRepositoryImpl implements PlaylistRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public PlaylistInfoEntity getPlaylist(int playlistId) {
        return null;
    }

    public boolean deletePlaylist(int playlistId) {
        return false;
    }

    public boolean updatePlaylist(PlaylistInfoEntity playlist) {
        return false;
    }

    public boolean insertPlaylist(PlaylistInfoEntity playlist) {
        return false;
    }

    public List<PlaylistInfoEntity> getAllPlaylist(int limit) {

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(PlaylistInfoEntity.class);
        List playListInfoEntity = criteria.addOrder(Order.asc("numView")).list();
        return playListInfoEntity;
    }

    public List<PlaylistInfoEntity> getListPlaylistOfUser(int accountId, int limit, int currentPlaylistId){
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(PlaylistInfoEntity.class);
        if(accountId<0){
            return null;
        }
        criteria.add(Restrictions.eq("accountId", accountId));
        if(currentPlaylistId>-1){
            criteria.add(Restrictions.lt("id", currentPlaylistId));
        }
        if(limit>0){
            criteria.setMaxResults(limit);
        }
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }
}
