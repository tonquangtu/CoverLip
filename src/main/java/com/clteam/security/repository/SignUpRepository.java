package com.clteam.security.repository;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;
import com.clteam.dataobject.VerificationTokenEntity;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
public interface SignUpRepository {

    public void saveAccountEntity(AccountEntity accountEntity);

    public void saveUserInfoEntity(UserInfoEntity userInfoEntity);

    public VerificationTokenEntity findByToken(String token);

    public void delete(VerificationTokenEntity verificationTokenEntity);

}
