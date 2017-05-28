package com.clteam.services.userservice.api;

import com.clteam.model.FollowingList;
import com.clteam.model.TopIdol;
import com.clteam.model.User;

import java.util.List;

/**
 * Created by Dell on 01-May-17.
 */
public interface UserService {

    public User getUser(int accountId);

    public List<TopIdol> getLipSyncIdols(int limit);

    FollowingList getIdolOfUser(int accountId, int limit, int currentIdolFollowingId);
    FollowingList getFanOfUser(int accountId, int limit, int currentIdolFollowingId);
}
