package com.clteam.repositories.impl;

import com.clteam.dataobject.UserInfoEntity;
import com.clteam.repositories.api.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;
    public UserInfoEntity getUserInfo(int userId) {
        return (UserInfoEntity)sessionFactory.getCurrentSession().get(UserInfoEntity.class, userId);
    }

    public UserInfoEntity getUserInfoByAccountId(int accountId) {
        return (UserInfoEntity)sessionFactory.getCurrentSession().createQuery("from UserInfoEntity where accountId="+accountId).list().get(0);
    }

    public UserInfoEntity getUser(int accountId) {
        return null;
    }

    public boolean deleteUser(int accountId) {
        return false;
    }

    public boolean updateUser(UserInfoEntity user) {
        return false;
    }

    public boolean insertUser(UserInfoEntity user) {
        return false;
    }

}
