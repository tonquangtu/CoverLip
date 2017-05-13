package com.clteam.repositories.impl;

import com.clteam.dataobject.*;
import com.clteam.model.Video;
import com.clteam.repositories.api.CoverRepository;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
 * Created by nguyenthanhtung on 27/04/2017.
 */
@Repository
@Transactional
public class CoverRepositoryImpl implements CoverRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public CoverInfoEntity getCoverInfo(int coverId) {
        return (CoverInfoEntity)sessionFactory.getCurrentSession().get(CoverInfoEntity.class, coverId);
    }

    public CoverInfoEntity getCoverInfoByVideoId(int videoId) {
        return null;
    }

    @Override
    public List<HotCoverEntity> getAllHotCover() {

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(HotCoverEntity.class);
        criteria.addOrder(Order.desc("priority"));
        return criteria.list();
    }

    @Override
    public List<HotCoverEntity> getLimitHotCover(int limit) {

        if (limit <= 0) {
            return null;
        }
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(HotCoverEntity.class);
        criteria.setMaxResults(limit);
        criteria.addOrder(Order.desc("priority"));
        criteria.setMaxResults(limit);
        return criteria.list();
    }

    @Override
    public List<CoverInfoEntity> getCoversInfoByName(String name, int limit) {

        if (name != null && name.length() > 0 && limit > 0) {

            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from CoverInfoEntity where coverName = :cover_name ");
            query.setMaxResults(limit);
            query.setParameter("cover_name", name);

            return query.list();
        }

        return null;
    }

    @Override
    public List<CoverOfPlaylistEntity> getPlaylistItemsByVideoId(int videoId, int limit) {

       if (videoId > 0 && limit > 0) {

           Query query = sessionFactory.getCurrentSession().createQuery("from CoverOfPlaylistEntity where videoId = :video_id");
           query.setParameter("video_id", videoId);
           query.setMaxResults(limit);

           return query.list();
       }

       return null;
      }

    @Override
    public List<CoverOfPlaylistEntity> getPlaylistItemsByPlaylistId(int playlistId) {
        if (playlistId > 0) {

            Query query = sessionFactory.getCurrentSession().createQuery("from CoverOfPlaylistEntity where playlistId = :playlist_id");
            query.setParameter("playlist_id", playlistId);

            return query.list();
        }

        return null;
    }

    @Override
    public PlaylistInfoEntity getPlaylist(int playlistId) {

        if (playlistId > 0) {
            Session session = sessionFactory.getCurrentSession();
            return (PlaylistInfoEntity)session.get(PlaylistInfoEntity.class, playlistId);
        }
        return null;
    }

    @Override
    public List<CoverInfoEntity> searchCoverByName(String name, int limit) {

        System.out.println("Input: " + name);
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

    @Override
    public List<CoverInfoEntity> findTopCoverOfAccount(int accountId, int limit) {

        if (accountId <= 0 && limit <= 0) {
            return null;
        }

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(CoverInfoEntity.class, "cover");
        criteria.createAlias("cover.videoInfoByVideoId", "video");
        criteria.add(Restrictions.eq("video.accountId", accountId));
        criteria.addOrder(Order.desc("video.numView"));
        criteria.setMaxResults(limit);

        return criteria.list();
    }

    public List<VideoInfoEntity> findTopCoverOfAccount2(int accountId, int limit) {

        if (accountId <= 0 && limit <= 0) {
            return null;
        }
        Session session = sessionFactory.getCurrentSession();
        Criteria videoCriteria = session.createCriteria(VideoInfoEntity.class);
        videoCriteria.add(Restrictions.eq("accountId", accountId));
        videoCriteria.add(Restrictions.eq("type", Video.COVER_TYPE));
        videoCriteria.setMaxResults(limit);
        videoCriteria.addOrder(Order.desc("numView"));

        return videoCriteria.list();
    }

    @Override
    public HotCoverEntity findHotCover(int videoId) {

        HotCoverEntity hotCoverEntity = null;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(HotCoverEntity.class);
        criteria.add(Restrictions.eq("videoId", videoId));

        List<HotCoverEntity> hotCoverEntities = criteria.list();
        if (hotCoverEntities != null && hotCoverEntities.size() > 0) {
            hotCoverEntity = hotCoverEntities.get(0);
        }
        return hotCoverEntity;
    }

    @Override
    public List<CoverInfoEntity> getAllCovers() {

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(CoverInfoEntity.class);
        return criteria.list();
    }

    @Override
    public List<HotCoverEntity> getAllHotCover(int limit) {
        return null;
    }

    @Override
    public List<NewCoverEntity> getListNewCover(int limit) {
        return null;
    }


}
