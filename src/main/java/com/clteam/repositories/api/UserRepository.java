package com.clteam.repositories.api;

import com.clteam.dataobject.UserInfo;

import java.util.Set;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public interface UserRepository {

    UserInfo getUser(int accountId);

    boolean deleteUser(int accountId);

    boolean updateUser(UserInfo user);

    boolean insertUser(UserInfo user);

    Set<UserInfo> getAllUser();


}
