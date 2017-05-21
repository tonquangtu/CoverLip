package com.clteam.services.userservice.api;

import com.clteam.model.FollowingList;
import com.clteam.model.User;

/**
 * Created by Dell on 01-May-17.
 */
public interface UserService {

    public void indexForAllTables();

    public User getUser(int accountId);

    FollowingList getIdolOfUser(int accountId, int limit, int currentIdolFollowingId);
    FollowingList getFanOfUser(int accountId, int limit, int currentIdolFollowingId);
}
