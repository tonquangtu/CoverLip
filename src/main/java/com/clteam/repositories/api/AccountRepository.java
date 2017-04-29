package com.clteam.repositories.api;

import com.clteam.dataobject.Account;

import java.util.List;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public interface AccountRepository {

    Account getAccount(int accountId);

    boolean deleteAccount(int accountId);

    boolean updateAccount(Account account);

    boolean insertAccount(Account account);

    List<Account> getAllAccount();


}
