package com.clteam.repositories.api;

import java.util.List;

/**
 * Created by Dell on 28-Apr-17.
 */
public interface PlaylistRepository {

    PlaylistInfo getPlaylist(int playlistId);

    boolean deletePlaylist(int playlistId);

    boolean updatePlaylist(PlaylistInfo playlist);

    boolean insertPlaylist(PlaylistInfo playlist);

    List<PlaylistInfo> getAllPlaylist();
}
