package com.clteam.security.service;

import com.clteam.dataobject.AccountEntity;
import com.clteam.security.constant.Token;
import com.clteam.security.dto.AccountDto;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
public interface SignUpService {

    public AccountEntity createNewAccount(AccountDto accountDto);

    public int createVerificationToken(AccountEntity accountEntity, String token);

    public Token validateVerificationToken(String token);

}
