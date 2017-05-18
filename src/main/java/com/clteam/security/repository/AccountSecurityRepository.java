package com.clteam.security.repository;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;

/**
 * Created by Khanh Nguyen on 5/5/2017.
 */
public interface AccountSecurityRepository {

    AccountEntity findByEmail(String email);

    void saveAccountEntity(AccountEntity accountEntity);

    void saveUserInfoEntity(UserInfoEntity userInfoEntity);

    AccountEntity findByUserId(String userId);

}
