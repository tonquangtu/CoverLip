package com.clteam.services.commonservice.api;

import com.clteam.dataobject.LipSyncInfoEntity;
import com.clteam.model.LipSync;

import java.util.List;

/**
 * Created by Dell on 21-May-17.
 */
public interface LipSyncService {

    public LipSync getLipSync(int videoId);

    public List<LipSync> getHotLipSyncs(int limit);

    public List<LipSync> getHotLipSyncsFrom(int start, int limit);

    public LipSync getLipSync(LipSyncInfoEntity lipSyncEntity);

}
