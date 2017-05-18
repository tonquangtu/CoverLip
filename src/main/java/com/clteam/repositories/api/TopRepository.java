package com.clteam.repositories.api;

import com.clteam.dataobject.TopCoverIdolEntity;
import com.clteam.dataobject.TopListEntity;

import java.util.List;

/**
 * Created by Dell on 28-Apr-17.
 */
public interface TopRepository {

    TopListEntity getTop(int topId);

    boolean deleteTop(int topId);

    boolean updateTop(TopListEntity top);

    boolean insertTop(TopListEntity top);

    List<TopCoverIdolEntity> getListTopCoverIdols(int limit);
    List<TopListEntity> getAllTop();

    TopListEntity getNewTop();
}
