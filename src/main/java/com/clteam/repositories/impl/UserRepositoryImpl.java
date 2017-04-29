package com.clteam.repositories.impl;

import com.clteam.dataobject.UserInfo;
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
    public UserInfo getUserInfo(int userId) {
        return (UserInfo)sessionFactory.getCurrentSession().get(UserInfo.class, userId);
    }

    public UserInfo getUserInfoByAccountId(int accountId) {
        return (UserInfo)sessionFactory.getCurrentSession().createQuery("from UserInfo where accountId="+accountId).list().get(0);
    }

    public UserInfo getUser(int accountId) {
        return null;
    }

    public boolean deleteUser(int accountId) {
        return false;
    }

    public boolean updateUser(UserInfo user) {
        return false;
    }

    public boolean insertUser(UserInfo user) {
        return false;
    }

    public List<UserInfo> getAllUser() {
        return null;
    }
}
