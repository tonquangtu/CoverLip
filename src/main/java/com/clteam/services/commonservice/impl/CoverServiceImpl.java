package com.clteam.services.commonservice.impl;

import com.clteam.dataobject.*;
import com.clteam.model.Cover;
import com.clteam.model.Playlist;
import com.clteam.model.PlaylistItem;
import com.clteam.model.Video;
import com.clteam.repositories.api.CoverRepository;
import com.clteam.repositories.api.PlaylistRepository;
import com.clteam.services.commonservice.api.CoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mrgnu on 19/05/2017.
 */
@Service
public class CoverServiceImpl implements CoverService {

    @Autowired
    private CoverRepository coverRepository;

    @Autowired
    PlaylistRepository playlistRepository;

    @Override
    public List<Cover> getListHotCover(int limit) {

        List<Cover> coverList = new ArrayList<Cover>();
        List<HotCoverEntity> hotCoverList = coverRepository.getLimitHotCover(limit);

        for (int i=0; i<hotCoverList.size(); i++){

            Cover cover = new Cover();
            VideoInfoEntity videoInfoEntity = hotCoverList.get(i).getVideoInfoByVideoId();
            Collection<CoverInfoEntity> coverInfoEntities = videoInfoEntity.getCoverInfosById();

            if (coverInfoEntities != null){

                CoverInfoEntity coverInfoEntity = (CoverInfoEntity) coverInfoEntities.toArray()[0];
                cover.copyData(coverInfoEntity, videoInfoEntity, videoInfoEntity.getAccountByAccountId());
                coverList.add(cover);
            }

        }

        return coverList;
    }

    @Override
    public List<Cover> getListNewCover(int limit) {

        List<NewCoverEntity> newCoverEntityList = coverRepository.getListNewCover(limit);
        List<Cover> coverList = new ArrayList<Cover>();
        for(int i=0; i<newCoverEntityList.size(); i++){
//            Cover cover = new Cover();
            VideoInfoEntity videoInfoEntity = newCoverEntityList.get(i).getVideoInfoByVideoId();
            Collection<CoverInfoEntity> coverInfoEntities =  videoInfoEntity.getCoverInfosById();
            if(coverInfoEntities!=null){
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity)coverInfoEntities.toArray()[0];
                Video video = new Video();
                video.copyData(videoInfoEntity, videoInfoEntity.getAccountByAccountId());
                Cover cover = new Cover(video, coverInfoEntity.getCoverName(), coverInfoEntity.getMp3Link());
//                cover.copyData(coverInfoEntity, videoInfoEntity, videoInfoEntity.getAccountByAccountId());
                coverList.add(cover);
            }
        }
        return coverList;
    }

    @Override
    public List<Cover> getListNewCover(int limit, int currentVideoId) {

        List<NewCoverEntity> newCoverEntityList = coverRepository.getListNewCover(limit, currentVideoId);
        List<Cover> coverList = new ArrayList<Cover>();
        for(int i=0; i<newCoverEntityList.size(); i++){
//            Cover cover = new Cover();
            VideoInfoEntity videoInfoEntity = newCoverEntityList.get(i).getVideoInfoByVideoId();
            Collection<CoverInfoEntity> coverInfoEntities =  videoInfoEntity.getCoverInfosById();
            if(coverInfoEntities!=null){
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity)coverInfoEntities.toArray()[0];
                Video video = new Video();
                video.copyData(videoInfoEntity, videoInfoEntity.getAccountByAccountId());
                Cover cover = new Cover(video, coverInfoEntity.getCoverName(), coverInfoEntity.getMp3Link());
//                cover.copyData(coverInfoEntity, videoInfoEntity, videoInfoEntity.getAccountByAccountId());
                coverList.add(cover);
            }
        }
        return coverList;
    }

    @Override
    public List<Playlist> getListPlayListCover(int limit) {

        List<Playlist> playlistList = new ArrayList<Playlist>();
        List<PlaylistInfoEntity> playlistInfoEntities = playlistRepository.getAllPlaylist(limit);

        for (int i=0; i<playlistInfoEntities.size(); i++){

            Playlist playlist = new Playlist();
            PlaylistInfoEntity playlistInfoEntity = playlistInfoEntities.get(i);
            List<PlaylistItem> items = new ArrayList<>();
            Collection<CoverOfPlaylistEntity> coverOfPlaylistEntities = playlistInfoEntity.getCoverOfPlaylistsById();
            if (coverOfPlaylistEntities != null){

                for (int k=0; k < coverOfPlaylistEntities.size(); k++){

                    PlaylistItem playlistItem = new PlaylistItem();

                    CoverOfPlaylistEntity coverOfPlaylistEntity = (CoverOfPlaylistEntity) coverOfPlaylistEntities.toArray()[k];
                    VideoInfoEntity videoInfoEntity = coverOfPlaylistEntity.getVideoInfoByVideoId();

                    Collection<CoverInfoEntity> coverInfoEntities = videoInfoEntity.getCoverInfosById();
                    if(coverInfoEntities !=null){
                        CoverInfoEntity coverInfoEntity = (CoverInfoEntity) coverInfoEntities.toArray()[0];
                        AccountEntity accountEntity = videoInfoEntity.getAccountByAccountId();
                        if(accountEntity !=null){
                            playlistItem.copyData(coverOfPlaylistEntity, coverInfoEntity, videoInfoEntity, accountEntity);
                        }
                    }

                    items.add(playlistItem);
                }
            }
            playlist.copyData(playlistInfoEntity, items, playlistInfoEntity.getAccountByAccountId());

            playlistList.add(playlist);
        }
        return playlistList;
    }
}
