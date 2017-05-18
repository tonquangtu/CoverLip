package com.clteam.security.repository;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
public interface SignUpRepository {

    public void saveAccountEntity(AccountEntity accountEntity);

    public void saveUserInfoEntity(UserInfoEntity userInfoEntity);

}
