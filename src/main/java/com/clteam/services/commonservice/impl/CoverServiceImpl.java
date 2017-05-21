package com.clteam.services.commonservice.impl;

import com.clteam.dataconstant.DataConstant;
import com.clteam.dataobject.*;
import com.clteam.model.*;
import com.clteam.repositories.api.CoverRepository;
import com.clteam.repositories.api.PlaylistRepository;
import com.clteam.repositories.api.TopRepository;
import com.clteam.repositories.api.VideoRepository;
import com.clteam.services.commonservice.api.CoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by nguyenthanhtung on 18/05/2017.
 */
@Service
public class CoverServiceImpl implements CoverService {
    @Autowired
    private CoverRepository coverRepository;
    @Autowired
    PlaylistRepository playlistRepository;
    @Autowired
    private TopRepository topRepository;
    @Autowired
    private VideoRepository videoRepository;

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
                    if(coverInfoEntities != null){
                        CoverInfoEntity coverInfoEntity = (CoverInfoEntity) coverInfoEntities.toArray()[0];
                        AccountEntity accountEntity = videoInfoEntity.getAccountByAccountId();
                        if(accountEntity != null){
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

    @Override
    public TopList<Cover> getListTopCover() {
        TopListEntity topListEntity = topRepository.getNewTop();
        if(topListEntity!=null){
            Collection<CoverTopEntity> coverTopEntities = topListEntity.getCoverTopsById();
            if(coverTopEntities!=null){

                List<CoverTopEntity> coverTopEntityList = new ArrayList<>();
                for(int i=0; i<coverTopEntities.size(); i++){
                    CoverTopEntity coverTopEntity = (CoverTopEntity) coverTopEntities.toArray()[i];
                    coverTopEntityList.add(coverTopEntity);
                }

                //Sort by num view
                coverTopEntityList.sort((coverTopEntity, t1) -> {
                    if (coverTopEntity.getNumViewPeriod() < t1.getNumViewPeriod()) {
                        return 1;
                    } else if (coverTopEntity.getNumViewPeriod() > t1.getNumViewPeriod()) {
                        return -1;
                    }
                    return 0;
                });


                List<Cover> coverList = new ArrayList<>();
                for(int i=0; i<coverTopEntityList.size(); i++){

                    CoverTopEntity coverTopEntity = coverTopEntityList.get(i);
                    VideoInfoEntity videoInfoEntity = coverTopEntity.getVideoInfoByVideoId();
                    if(videoInfoEntity==null){
                        break;
                    }
                    AccountEntity accountEntity = videoInfoEntity.getAccountByAccountId();
                    Collection<CoverInfoEntity> coverInfoEntities = videoInfoEntity.getCoverInfosById();

                    if(coverInfoEntities!=null && accountEntity!=null){
                        CoverInfoEntity coverInfoEntity = (CoverInfoEntity) coverInfoEntities.toArray()[0];
                        Cover cover = new Cover();
                        cover.copyData(coverInfoEntity, videoInfoEntity, accountEntity);
                        coverList.add(cover);
                    }
                }

                TopList<Cover> topList = new TopList<>();
                topList.setTimeTopStart(topListEntity.getTimeTopStart());
                topList.setTimeEndStart(topListEntity.getTimeEndStart());
                topList.setItems(coverList);
                return topList;
            }
        }
        return null;
    }

    @Override
    public List<Cover> getListCoverOfUser(int accountId, int limit, int currentVideoId) {
        List<VideoInfoEntity> videoInfoEntities = videoRepository.getListVideoOfAccountByType(accountId, limit, DataConstant.TYPE_COVER, currentVideoId);
        if(videoInfoEntities==null){
            return null;
        }

        List<Cover> listCoverOfUser = new ArrayList<>();
        for(int i=0; i<videoInfoEntities.size(); i++){
            Video video = new Video();
            VideoInfoEntity videoInfoEntity = videoInfoEntities.get(i);
            AccountEntity accountEntity = videoInfoEntity.getAccountByAccountId();
            if(accountEntity!=null){
                video.copyData(videoInfoEntity, accountEntity);
                Collection<CoverInfoEntity> coverInfoEntities = videoInfoEntity.getCoverInfosById();
                if(coverInfoEntities !=null){
                    Cover cover = new Cover();
                    cover.copyData((CoverInfoEntity) coverInfoEntities.toArray()[0],videoInfoEntity,accountEntity);
                    listCoverOfUser.add(cover);
                }
            }
        }
        return listCoverOfUser;
    }

    public List<Playlist> getListPlaylistOfUser(int accountId, int limit, int currentPlaylistId){
        List<PlaylistInfoEntity> playlistInfoEntities = playlistRepository.getListPlaylistOfUser(accountId, limit, currentPlaylistId);
        if(playlistInfoEntities==null || playlistInfoEntities.size()==0){
            return null;
        }
        List<Playlist> playlistList = new ArrayList<>();
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
