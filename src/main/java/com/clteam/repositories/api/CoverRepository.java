package com.clteam.repositories.api;


import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.CoverOfPlaylistEntity;
import com.clteam.dataobject.HotCoverEntity;
import com.clteam.dataobject.PlaylistInfoEntity;

import java.util.List;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public interface CoverRepository {

    CoverInfoEntity getCoverInfo(int coverId);

    CoverInfoEntity getCoverInfoByVideoId(int videoId);

    List<HotCoverEntity> getAllHotCover();

    List<HotCoverEntity> getLimitHotCover(int limit);

    List<CoverInfoEntity> getCoversInfoByName(String name, int limit);

    List<CoverOfPlaylistEntity> getPlaylistItemsByVideoId(int videoId, int limit);

    List<CoverOfPlaylistEntity> getPlaylistItemsByPlaylistId(int playlistId);

    PlaylistInfoEntity getPlaylist(int playlistId);

    List<CoverInfoEntity> searchCoverByName(String name, int limit);

    List<CoverInfoEntity> findTopCoverOfAccount(int accountId, int limit);

}
