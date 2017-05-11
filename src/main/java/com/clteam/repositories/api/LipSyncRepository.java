package com.clteam.repositories.api;

import com.clteam.dataobject.LipSyncInfoEntity;
import com.clteam.dataobject.LipSyncTemplateInfoEntity;

import java.util.List;

/**
 * Created by Dell on 28-Apr-17.
 */
public interface LipSyncRepository {

    public List<LipSyncTemplateInfoEntity> searchLipSyncByName(String name, int limit);

    public int insertTemplate(LipSyncTemplateInfoEntity templateEntity);

    public int insertLipSync(LipSyncInfoEntity lipSync);

    public LipSyncInfoEntity getLipSync(int videoId);

    public LipSyncTemplateInfoEntity getLipSyncTemplate(int videoId);
}
