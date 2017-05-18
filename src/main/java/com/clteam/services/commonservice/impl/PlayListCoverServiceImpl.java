package com.clteam.services.commonservice.impl;

import com.clteam.dataobject.*;
import com.clteam.model.Playlist;
import com.clteam.model.PlaylistItem;
import com.clteam.repositories.api.PlaylistRepository;
import com.clteam.services.commonservice.api.PlayListCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mrgnu on 04/05/2017.
 */
@Service
public class PlayListCoverServiceImpl implements PlayListCoverService {

    @Autowired
    PlaylistRepository playlistRepository;

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
