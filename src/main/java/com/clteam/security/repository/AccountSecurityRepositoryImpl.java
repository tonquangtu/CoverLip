package com.clteam.security.repository;

import com.clteam.dataobject.AccountEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Khanh Nguyen on 5/5/2017.
 */
@Repository
public class AccountSecurityRepositoryImpl implements AccountSecurityRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public AccountEntity findByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().
                createQuery("from AccountEntity where username=:username");
        query.setParameter("username", email);
        return (AccountEntity) query.uniqueResult();
    }

    @Override
    public void saveAccountEntity(AccountEntity accountEntity) {
        sessionFactory.getCurrentSession().save(accountEntity);
    }

    @Override
    public AccountEntity findByUserId(String userId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from AccountEntity where id=:userId");
        int id = Integer.parseInt(userId);
        query.setParameter("userId", id);
        return (AccountEntity) query.uniqueResult();
    }
}