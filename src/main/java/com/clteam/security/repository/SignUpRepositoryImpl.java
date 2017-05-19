package com.clteam.security.repository;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;
import com.clteam.dataobject.VerificationTokenEntity;
import org.hibernate.Query;
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
        sessionFactory.getCurrentSession().save(accountEntity);
    }

    @Override
    public void saveUserInfoEntity(UserInfoEntity userInfoEntity) {
        sessionFactory.getCurrentSession().save(userInfoEntity);
    }

    @Override
    public VerificationTokenEntity findByToken(String token) {
        Query query = sessionFactory.getCurrentSession().
                createQuery("from VerificationTokenEntity where token=:token");
        query.setParameter("token", token);
        return (VerificationTokenEntity) query.uniqueResult();
    }

    @Override
    public void delete(VerificationTokenEntity verificationTokenEntity) {
        sessionFactory.getCurrentSession().delete(verificationTokenEntity);
    }
}
