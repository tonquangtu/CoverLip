package com.clteam.security.service;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;
import com.clteam.model.User;
import com.clteam.security.repository.AdminAccountRepository;
import com.clteam.security.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Khanh Nguyen on 21/5/2017.
 */
@Service
@Transactional
public class AdminAccountServiceImpl implements AdminAccountService {

    @Autowired
    private AdminAccountRepository adminAccountRepository;

    @Override
    public List<User> findAllUser() {
        List<AccountEntity> listAccountEntity = adminAccountRepository.findAll();
        List<User> listUser = new ArrayList<>();
        for (AccountEntity accountEntityItem : listAccountEntity) {
            User u = new User();
            Collection<UserInfoEntity> userInfoEntity = accountEntityItem.getUserInfosById();
            if (userInfoEntity != null && !userInfoEntity.isEmpty()) {
                u.copyData(userInfoEntity.iterator().next(), accountEntityItem);
            }
            listUser.add(u);
        }
        return listUser;
    }

    @Override
    public PaginationUtil<User> pagingUser(int currentPage) {
        return new PaginationUtil<User>(adminAccountRepository.getQueryAccountList(), currentPage);
    }

}
