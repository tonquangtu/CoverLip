package com.clteam.security.repository;

import com.clteam.dataobject.AccountEntity;
import com.clteam.model.User;
import com.clteam.security.constant.SecurityConstant;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Khanh Nguyen on 21/5/2017.
 */
@Repository
public class AdminAccountRepositoryImpl implements AdminAccountRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AccountEntity> findAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from AccountEntity where role=:role")
                .setParameter("role", SecurityConstant.ROLE_USER_BYTE)
                .list();
    }

    @Override
    public Query getQuery() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select new " + User.class.getName() +
                        "(a)" +
                        " from AccountEntity a where role=:role")
                .setParameter("role", SecurityConstant.ROLE_USER_BYTE);
    }

}