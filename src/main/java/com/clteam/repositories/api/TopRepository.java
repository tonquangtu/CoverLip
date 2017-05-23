package com.clteam.repositories.api;

import com.clteam.dataobject.TopCoverIdolEntity;
import com.clteam.dataobject.TopLipSyncIdolEntity;
import com.clteam.dataobject.TopListEntity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 28-Apr-17.
 */
public interface TopRepository {

    TopListEntity getTop(int topId);

    boolean deleteTop(int topId);

    boolean updateTop(TopListEntity top);

    boolean insertTop(TopListEntity top);

    List<TopCoverIdolEntity> getListTopCoverIdols(int limit, int topId);

    List<TopListEntity> getAllTop();

    public int getMaxTopId();

    TopListEntity getNewTop();

    List<TopLipSyncIdolEntity> getListTopLipSyncIdols(int limit, int topId);

    int setFollowIdol(int acoundId, int topId, Timestamp timestampFollow);

    int unFollowIdol(int acoundId, int topId);
}
