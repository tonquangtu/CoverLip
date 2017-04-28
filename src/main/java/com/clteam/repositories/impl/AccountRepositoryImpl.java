package com.clteam.repositories.impl;

import com.clteam.dataobject.Account;
import com.clteam.repositories.api.AccountRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Account getAccount(int accountId) {
        return (Account)sessionFactory.getCurrentSession().get(Account.class, accountId);
    }

    public boolean deleteAccount(int accountId) {
        return false;
    }

    public boolean updateAccount(Account account) {
        return false;
    }

    public boolean insertAccount(Account account) {
        return false;
    }

    public Set<Account> getAllAccount() {
        return null;
    }
}