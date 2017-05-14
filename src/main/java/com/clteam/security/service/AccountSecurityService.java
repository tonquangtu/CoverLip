package com.clteam.security.service;

import com.clteam.dataobject.AccountEntity;
import org.springframework.social.connect.Connection;

/**
 * Created by Khanh Nguyen on 5/5/2017.
 */
public interface AccountSecurityService {

    AccountEntity findByEmail(String email);

    AccountEntity findByUserId(String userId);

    void saveAccountEntity(AccountEntity accountEntity);

    AccountEntity createNewAccount(Connection<?> conn);

}
