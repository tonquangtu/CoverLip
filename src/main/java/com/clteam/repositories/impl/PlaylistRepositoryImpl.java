package com.clteam.repositories.impl;

import com.clteam.dataobject.PlaylistInfoEntity;
import com.clteam.repositories.api.PlaylistRepository;
import org.hibernate.SessionFactory;
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

        return sessionFactory.getCurrentSession().createQuery("from PlaylistInfoEntity").list();
    }
}
