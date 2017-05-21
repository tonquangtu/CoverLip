package com.clteam.security.repository;

import com.clteam.dataobject.AccountEntity;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Khanh Nguyen on 21/5/2017.
 */
public interface AdminAccountRepository {

    public List<AccountEntity> findAll();

    public Query getQuery();

}
