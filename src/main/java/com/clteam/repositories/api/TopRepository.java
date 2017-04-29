package com.clteam.repositories.api;

import com.clteam.dataobject.TopList;

import java.util.Set;

/**
 * Created by Dell on 28-Apr-17.
 */
public interface TopRepository {

    TopList getTop(int topId);

    boolean deleteTop(int topId);

    boolean updateTop(TopList top);

    boolean insertTop(TopList top);

    Set<TopList> getAllTop();
}
