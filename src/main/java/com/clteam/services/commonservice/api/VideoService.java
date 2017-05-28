package com.clteam.services.commonservice.api;

import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.LipSyncInfoEntity;
import com.clteam.dataobject.LipSyncTemplateInfoEntity;
import com.clteam.dataobject.VideoInfoEntity;
import com.clteam.model.*;

import java.util.List;

/**
 * Created by Dell on 28-Apr-17.
 */
public interface VideoService {

     Cover getCoverInfo(int videoId);

     List<Cover> getHotCovers(int limit);

     List<Cover> getCoversByName(String name, int limit);

     List<Cover> getCoversByAccountId(int accountId, int limit);

     List<Playlist> findCoversSamePlaylist(int videoId, int limit);

     List<Cover> searchCoverByName(String name, int limit);

     List<Video> findTopVideoOfAccount(int accountId, int limit);

     List<Cover> findTopCoverOfAccount(int accountId, int limit);

     CoverWrapper getCoverWrapper(Cover cover);

     LipSyncWrapper getLipSyncWrapper(LipSync lipSync);

     List<LipSync> getHotLipSyncs(int limit);

     List<LipSync> searchLipSyncByName(String name, int limit);

     void createTestLipSyncData();

     LipSync getLipSync(int videoId);

    List<LipSync> findTopLipSyncOfAccount(int accountId, int limit);

     public Video getVideo(VideoInfoEntity videoEntity);


     List<LipSync> getListLipSyncOfUser(int accountId, int limit, int currentVideoId);

     public Cover getCoverInfo(VideoInfoEntity videoEntity);

     public List<Cover> getCovers(List<CoverInfoEntity> coverInfoEntities);

    public List<LipSync> getLipSyncs(List<LipSyncTemplateInfoEntity> lipSyncTemplates, int limit);

    public List<LipSync> getLipSyncs(List<LipSyncInfoEntity> lipSyncEntities);

}
