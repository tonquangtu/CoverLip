package com.clteam.security.service;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;
import com.clteam.security.constant.Constant;
import com.clteam.security.dto.AccountDto;
import com.clteam.security.repository.AccountSecurityRepository;
import com.clteam.security.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
@Service
@Transactional
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private AccountSecurityRepository accountSecurityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveAccount(AccountDto accountDto) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUsername(accountDto.getEmail());
        accountEntity.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        accountEntity.setFullname(accountEntity.getFullname());
        accountEntity.setRole((byte) Constant.ROLE_USER_INT);
        accountEntity.setState((byte) Constant.ACCOUNT_NON_ACTIVATED);
        accountEntity.setDateJoin(DateTimeUtil.getCurrentTime());
        accountSecurityRepository.saveAccountEntity(accountEntity);

        UserInfoEntity userInfoEntity = new UserInfoEntity();
    }

}
