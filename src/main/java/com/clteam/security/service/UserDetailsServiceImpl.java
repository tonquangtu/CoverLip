package com.clteam.security.service;

import com.clteam.dataobject.AccountEntity;
import com.clteam.security.constant.Constant;
import com.clteam.security.model.CustomUser;
import com.clteam.security.repository.AccountSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Khanh Nguyen on 5/5/2017.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountSecurityRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("### Load user by username");
        System.out.println("### load user by username: email: " + email);
        AccountEntity accountEntity = userRepository.findByEmail(email);
        if (accountEntity == null) {
            System.out.println("### not found account entity");
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        // Set<Role> roles = user.getRoles();
        // for (Role role : roles) {
        // grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        // }

        int role = accountEntity.getRole();
        if (role == Constant.ROLE_ADMIN_INT) {
            grantedAuthorities.add(new SimpleGrantedAuthority(Constant.ROLE_ADMIN_STR));
        } else if (role == Constant.ROLE_USER_INT) {
            grantedAuthorities.add(new SimpleGrantedAuthority(Constant.ROLE_USER_STR));
        }
        return new CustomUser(accountEntity.getUsername(), accountEntity.getPassword(), grantedAuthorities, accountEntity.getFullname());
    }

}
