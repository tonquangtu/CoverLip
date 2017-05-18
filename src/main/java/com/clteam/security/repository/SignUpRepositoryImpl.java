package com.clteam.security.repository;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
@Repository
public class SignUpRepositoryImpl implements SignUpRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveAccountEntity(AccountEntity accountEntity) {

    }

    @Override
    public void saveUserInfoEntity(UserInfoEntity userInfoEntity) {

    }
}
