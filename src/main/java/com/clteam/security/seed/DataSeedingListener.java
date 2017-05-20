package com.clteam.security.seed;

import com.clteam.dataobject.AccountEntity;
import com.clteam.security.constant.SecurityConstant;
import com.clteam.security.service.AccountSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Khanh Nguyen on 5/5/2017.
 */
@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountSecurityService userService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        insertAccount("admin@gmail.com",
//                "Abc@1234",
//                "Khanh Nguyen",
//                (byte) Constant.ROLE_ADMIN_INT,
//                (byte) Constant.ACCOUNT_ACTIVATED);
    }

    private void insertAccount(String email, String pwd, String fullName, byte role, byte status) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUsername(email);
        accountEntity.setPassword(passwordEncoder.encode(pwd));
        accountEntity.setFullname(fullName);
        accountEntity.setRole(role);
        accountEntity.setState((byte) SecurityConstant.ACCOUNT_ACTIVATED);
        accountEntity.setDateJoin(new Timestamp(new Date().getTime()));
        if (userService.findByEmail(accountEntity.getUsername()) == null) {
            System.out.println("### Begin insert account");
            userService.saveAccountEntity(accountEntity);
        }
    }
}
