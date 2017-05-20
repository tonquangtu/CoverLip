package com.clteam.services.userservice.api;

import com.clteam.model.TopIdol;
import com.clteam.model.User;

import java.util.List;

/**
 * Created by Dell on 01-May-17.
 */
public interface UserService {

    public void indexForAllTables();

    public User getUser(int accountId);

    public List<TopIdol> getLipSyncIdols(int limit);

}
