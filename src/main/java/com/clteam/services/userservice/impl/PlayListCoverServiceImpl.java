package com.clteam.services.userservice.impl;

import com.clteam.dataobject.PlaylistInfoEntity;
import com.clteam.model.Playlist;
import com.clteam.repositories.api.PlaylistRepository;
import com.clteam.services.userservice.api.PlayListCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            playlist.copyData(playlistInfoEntity);

            playlistList.add(playlist);
        }
        return playlistList;
    }
}
