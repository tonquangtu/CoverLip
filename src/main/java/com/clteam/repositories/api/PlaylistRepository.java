package com.clteam.repositories.api;

import com.clteam.dataobject.PlaylistInfoEntity;

import java.util.List;

/**
 * Created by Dell on 28-Apr-17.
 */
public interface PlaylistRepository {

    PlaylistInfoEntity getPlaylist(int playlistId);

    boolean deletePlaylist(int playlistId);

    boolean updatePlaylist(PlaylistInfoEntity playlist);

    boolean insertPlaylist(PlaylistInfoEntity playlist);

    List<PlaylistInfoEntity> getAllPlaylist(int limit);
}
