package com.clteam.repositories.api;

import com.clteam.dataobject.TopLipSyncIdolEntity;
import com.clteam.dataobject.UserInfoEntity;

import java.util.List;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public interface UserRepository {

    UserInfoEntity getUser(int accountId);

    boolean deleteUser(int accountId);

    boolean updateUser(UserInfoEntity user);

    boolean insertUser(UserInfoEntity user);

    List<UserInfoEntity> getAllUser();

    public UserInfoEntity getUserInfoByAccountId(int accountId);

    public void indexTables();

    public List<TopLipSyncIdolEntity> getTopLipSyncIdols(int limit);



}
