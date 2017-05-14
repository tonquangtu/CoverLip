package com.clteam.security.repository;

import com.clteam.dataobject.AccountEntity;

/**
 * Created by Khanh Nguyen on 5/5/2017.
 */
public interface AccountSecurityRepository {

    AccountEntity findByEmail(String email);

    void saveAccountEntity(AccountEntity accountEntity);

    AccountEntity findByUserId(String userId);

}
