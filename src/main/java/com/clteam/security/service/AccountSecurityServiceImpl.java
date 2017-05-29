package com.clteam.security.service;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;
import com.clteam.security.constant.SecurityConstant;
import com.clteam.security.repository.AccountSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Khanh Nguyen on 5/5/2017.
 */

@Service
@Transactional
public class AccountSecurityServiceImpl implements AccountSecurityService {

    @Autowired
    private AccountSecurityRepository userRepository;

    @Override
    public AccountEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public AccountEntity findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public void saveAccountEntity(AccountEntity accountEntity) {
        userRepository.saveAccountEntity(accountEntity);
    }

    @Override
    public void saveUserInfoEntity(UserInfoEntity userInfoEntity) {
        userRepository.saveUserInfoEntity(userInfoEntity);
    }

    @Override
    public AccountEntity createNewAccount(Connection<?> conn) {
        if (conn == null ) {
            System.out.println("conn is null");
            return null;
        } else {
            System.out.println("### Begin create account social");
            ConnectionKey key = conn.getKey();
            System.out.println("### key = " + key.getProviderId() + ", " + key.getProviderUserId());
            UserProfile userProfile = conn.fetchUserProfile();
            String email = userProfile.getEmail();
            AccountEntity account = findByEmail(email);
            if (account != null) {
                System.out.println("### return account is not null");
                return account;
            } else {
                AccountEntity newAccount = new AccountEntity();
                newAccount.setUsername(userProfile.getEmail());
                newAccount.setPassword("");
                newAccount.setFullname(userProfile.getFirstName() + " " + userProfile.getLastName());
                newAccount.setState(SecurityConstant.ACCOUNT_NON_ACTIVATED);
                newAccount.setRole(SecurityConstant.ROLE_USER_BYTE);
                newAccount.setDateJoin(new Timestamp(new Date().getTime()));
                saveAccountEntity(newAccount);
                return userRepository.findByEmail(newAccount.getUsername());
            }
        }
    }

    @Override
    public boolean saveAccountStatusDto(String accountId, String statusAccount) {

        AccountEntity accountEntity = findByUserId(accountId);
        byte currentState = accountEntity.getState();
        int clientState = Integer.parseInt(statusAccount);
        if ((byte) clientState != currentState && (clientState == 0 || clientState == 1 || clientState == 2)) {
            accountEntity.setState((byte) clientState);
            saveAccountEntity(accountEntity);
            return true;
        }
        return false;
    }
}
