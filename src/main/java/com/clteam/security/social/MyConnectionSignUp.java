package com.clteam.security.social;

import com.clteam.dataobject.AccountEntity;
import com.clteam.security.service.AccountSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

/**
 * Created by Khanh Nguyen on 9/5/2017.
 */
@Service
public class MyConnectionSignUp implements ConnectionSignUp {

    @Autowired
    private AccountSecurityService accountSecurityService;

    @Override
    public String execute(Connection<?> connection) {
        System.out.println("### execute in MyConnectionSignUp class");
        AccountEntity account = accountSecurityService.createNewAccount(connection);
        return String.valueOf(account.getId());
    }
}
