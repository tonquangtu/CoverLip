package com.clteam.security.service;

import com.clteam.dataobject.AccountEntity;

/**
 * Created by Khanh Nguyen on 7/5/2017.
 */
public interface SecurityService {

    public String findLoggedInUserName();

    public void autoLogin(String username, String password);

}
