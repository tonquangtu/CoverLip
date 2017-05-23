package com.clteam.security.social;

import com.clteam.dataobject.AccountEntity;
import com.clteam.security.constant.SecurityConstant;
import com.clteam.security.model.CustomSocialUser;
import com.clteam.security.service.AccountSecurityService;
import com.clteam.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Khanh Nguyen on 9/5/2017.
 */
@Service
public class MySocialUserDetailsService implements SocialUserDetailsService {

    @Autowired
    private AccountSecurityService accountSecurityService;

    @Autowired
    private SecurityService securityService;

    @Override
    public SocialUserDetails loadUserByUserId(String s) throws UsernameNotFoundException {
        return findUserByUserId(s);
//        return findUserByEmail(s);
    }

    private SocialUserDetails findUserByEmail(String email) {
        System.out.println("### Load user by email: " + email);
        AccountEntity accountEntity = accountSecurityService.findByEmail(email);
        if (accountEntity == null) {
            System.out.println("### not found account entity");
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(SecurityConstant.ROLE_USER_STR));
        return new SocialUser(String.valueOf(accountEntity.getId()), "", grantedAuthorities);
    }

    private SocialUserDetails findUserByUserId(String userId) {
        System.out.println("### Load user by userId: " + userId);
        AccountEntity accountEntity = accountSecurityService.findByUserId(userId);
        if (accountEntity == null) {
            System.out.println("### not found account entity");
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(SecurityConstant.ROLE_USER_STR));
        return new CustomSocialUser(String.valueOf(accountEntity.getId()), "",
                grantedAuthorities, accountEntity.getFullname(), accountEntity.getState());
    }

}
