package com.clteam.security.service;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;
import com.clteam.dataobject.VerificationTokenEntity;
import com.clteam.security.constant.SecurityConstant;
import com.clteam.security.constant.ActivateAccountToken;
import com.clteam.security.dto.AccountDto;
import com.clteam.security.repository.AccountSecurityRepository;
import com.clteam.security.repository.SignUpRepository;
import com.clteam.security.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
@Service
@Transactional
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private AccountSecurityRepository accountSecurityRepository;

    @Autowired
    private SignUpRepository signUpRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AccountEntity createNewAccount(AccountDto accountDto) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUsername(accountDto.getEmail());
        accountEntity.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        accountEntity.setFullname(accountDto.getFullName());
        accountEntity.setRole((byte) SecurityConstant.ROLE_USER_INT);
        accountEntity.setState((byte) SecurityConstant.ACCOUNT_NON_ACTIVATED);
        accountEntity.setDateJoin(DateTimeUtil.getCurrentTime());
        int accountId = accountSecurityRepository.saveAccountEntity(accountEntity);

        System.out.println("### address: " + accountDto.getAddress());

        AccountEntity newAccount = accountSecurityRepository.findByEmail(accountEntity.getUsername());

        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setAccountId(accountId);
        userInfoEntity.setNumCover(0);
        userInfoEntity.setNumHaveFollowed(0);
        userInfoEntity.setNumLipsync(0);
        userInfoEntity.setNumPlaylist(0);
        userInfoEntity.setDateOfBirth(DateTimeUtil.convertDateToTimestamp(accountDto.getDateOfBirth()));
        userInfoEntity.setAddress(accountDto.getAddress());
        userInfoEntity.setDescription("");
        accountSecurityRepository.saveUserInfoEntity(userInfoEntity);

        return newAccount;
    }

    @Override
    public int createVerificationToken(AccountEntity accountEntity, String token) {
        VerificationTokenEntity verificationTokenEntity = new VerificationTokenEntity(token);
        verificationTokenEntity.setAccountId(accountEntity.getId());
        return accountSecurityRepository.saveVerificationTokenEntity(verificationTokenEntity);
    }

    @Override
    public ActivateAccountToken validateVerificationToken(String token) {
        final VerificationTokenEntity verificationToken = signUpRepository.findByToken(token);
        if (verificationToken == null) {
            return ActivateAccountToken.TOKEN_INVALID;
        }
        final AccountEntity account = verificationToken.getAccountByAccountId();
        final Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            signUpRepository.delete(verificationToken);
            return ActivateAccountToken.TOKEN_EXPIRED;
        }
        account.setState((byte) SecurityConstant.ACCOUNT_ACTIVATED);
        signUpRepository.saveAccountEntity(account);
        return ActivateAccountToken.TOKEN_VALID;
    }

}
