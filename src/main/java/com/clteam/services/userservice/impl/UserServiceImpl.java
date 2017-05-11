package com.clteam.services.userservice.impl;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;
import com.clteam.model.Account;
import com.clteam.model.User;
import com.clteam.repositories.api.UserRepository;
import com.clteam.services.userservice.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dell on 01-May-17.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepo;

    public void indexForAllTables() {

        userRepo.indexTables();
    }

    public User getUser(int accountId) {

        User user = null;
        UserInfoEntity userEntity = userRepo.getUserInfoByAccountId(accountId);

        if (userEntity != null) {
            user = new User();
            user.copyData(userEntity);
            AccountEntity accountEntity = userEntity.getAccountByAccountId();
            Account account = new Account();
            if (accountEntity != null) {
                account.copyData(accountEntity);
            }
            user.setAccount(account);
        }
        return user;
    }



}
