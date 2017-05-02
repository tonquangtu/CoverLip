package com.clteam.repositories.api;

import com.clteam.dataobject.AccountEntity;

import java.util.List;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public interface AccountRepository {

    AccountEntity getAccount(int accountId);

    boolean deleteAccount(int accountId);

    boolean updateAccount(AccountEntity account);

    boolean insertAccount(AccountEntity account);

}
