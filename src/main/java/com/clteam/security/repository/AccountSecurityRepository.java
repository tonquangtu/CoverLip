package com.clteam.security.repository;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;
import com.clteam.dataobject.VerificationTokenEntity;

/**
 * Created by Khanh Nguyen on 5/5/2017.
 */
public interface AccountSecurityRepository {

    AccountEntity findByEmail(String email);

    int saveAccountEntity(AccountEntity accountEntity);

    void saveUserInfoEntity(UserInfoEntity userInfoEntity);

    AccountEntity findByUserId(String userId);

    int saveVerificationTokenEntity(VerificationTokenEntity verificationTokenEntity);

}
