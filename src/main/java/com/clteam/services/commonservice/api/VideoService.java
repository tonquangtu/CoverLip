package com.clteam.services.commonservice.api;

import com.clteam.model.Cover;
import com.clteam.model.Playlist;

import java.util.List;

/**
 * Created by Dell on 28-Apr-17.
 */
public interface VideoService {

    public Cover getCoverInfo(int videoId);

    public List<Cover> getHotCovers(int limit);

    public List<Cover> getCoversByName(String name, int limit);

    public List<Cover> getCoversByAccountId(int accountId, int limit);

    public List<Playlist> findCoversSamePlaylist(int videoId, int limit);

    public List<Cover> searchCoverByName(String name, int limit);

    public List<Cover> findTopCoverOfAccount(int accountId, int limit);
}
