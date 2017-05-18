package com.clteam.security.service;

import com.clteam.dataobject.AccountEntity;
import com.clteam.security.dto.AccountDto;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
public interface SignUpService {

    public AccountEntity createNewAccount(AccountDto accountDto);

    public void createVerificationToken(AccountEntity accountEntity, String token);

}
