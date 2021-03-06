package com.clteam.repositories.api;

import com.clteam.dataobject.HotLipSyncEntity;
import com.clteam.dataobject.LipSyncInfoEntity;
import com.clteam.dataobject.LipSyncTemplateInfoEntity;
import com.clteam.dataobject.NewLipsyncEntity;

import java.util.List;

/**
 * Created by Dell on 28-Apr-17.
 */
public interface LipSyncRepository {

    List<LipSyncTemplateInfoEntity> searchLipSyncByName(String name, int limit);

    int insertTemplate(LipSyncTemplateInfoEntity templateEntity);

    int insertLipSync(LipSyncInfoEntity lipSync);

    LipSyncInfoEntity getLipSync(int videoId);

    LipSyncTemplateInfoEntity getLipSyncTemplate(int videoId);

    List<LipSyncInfoEntity> findTopLipSyncOfAccount(int accountId, int limit);

    List<HotLipSyncEntity> getLimitHotLipSync(int limit);

    HotLipSyncEntity findHotLipSync(int videoId);

    List<HotLipSyncEntity> getHotLipSyncsFrom(int start, int limit);

    List<LipSyncInfoEntity> getListLipSyncOfUser(int accountId, int limit, int currentVideoId);

    List<NewLipsyncEntity> getListNewLipsync(int limit);

    List<LipSyncInfoEntity> getListLipsync(int limit, int currentVideoId);
}
