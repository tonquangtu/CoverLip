package com.clteam.security.service;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;
import org.springframework.social.connect.Connection;

/**
 * Created by Khanh Nguyen on 5/5/2017.
 */
public interface AccountSecurityService {

    AccountEntity findByEmail(String email);

    AccountEntity findByUserId(String userId);

    void saveAccountEntity(AccountEntity accountEntity);

    void saveUserInfoEntity(UserInfoEntity userInfoEntity);

    AccountEntity createNewAccount(Connection<?> conn);

    boolean saveAccountStatusDto(String accountId, String statusAccount);

}
