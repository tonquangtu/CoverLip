package com.clteam.security.dto;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;

/**
 * Created by Khanh Nguyen on 21/5/2017.
 */

public class AccountUserDto {

    private AccountEntity accountEntity;
    private UserInfoEntity userInfoEntity;

    public AccountUserDto(AccountEntity accountEntity, UserInfoEntity userInfoEntity) {
        this.accountEntity = accountEntity;
        this.userInfoEntity = userInfoEntity;
    }

}
