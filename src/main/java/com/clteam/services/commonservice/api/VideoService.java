package com.clteam.services.commonservice.api;

import com.clteam.model.*;

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

    public List<Video> findTopVideoOfAccount(int accountId, int limit);

    public List<Cover> findTopCoverOfAccount(int accountId, int limit);

    public CoverWrapper getCoverWrapper(Cover cover);

    public List<LipSync> getHotLipSyncs(int limit);

    public List<LipSync> searchLipSyncByName(String name, int limit);

    public void createTestLipSyncData();

    public LipSync getLipSync(int videoId);


}
