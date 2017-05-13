package com.clteam.repositories.impl;

import com.clteam.dataobject.AccountEntity;
import com.clteam.repositories.api.AccountRepository;
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
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public AccountEntity getAccount(int accountId) {
        return (AccountEntity)sessionFactory.getCurrentSession().get(AccountEntity.class, accountId);
    }

    public boolean deleteAccount(int accountId) {
        return false;
    }

    public boolean updateAccount(AccountEntity account) {
        return false;
    }

    public boolean insertAccount(AccountEntity account) {
        return false;
    }

    public List<AccountEntity> getAllAccount() {
        return null;
    }
}
