package com.clteam.services.userservice.api;


import com.clteam.model.TopIdol;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by mrgnu on 30/04/2017.
 */
public interface TopIdolService {

    public List<TopIdol> getListTopCoverIdols(int limit);
    public List<TopIdol> getListTopLipSyncIdols(int limit);
    public int setFollowIdol(int acoundId, int topId, Timestamp timestampFollow);
    public int unFollowIdol(int acoundId, int topId);
    public int checkFollowIdol(int acoundId, int acoundFollowId);
}
