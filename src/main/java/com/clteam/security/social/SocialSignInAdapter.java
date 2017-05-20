package com.clteam.security.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Arrays;

@Service
public class SocialSignInAdapter implements SignInAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
        System.out.println("### Sign In adapter");
        UserDetails userDetails = userDetailsService.loadUserByUsername(connection.getDisplayName());
        System.out.println("### conn display name: " + connection.getDisplayName());
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(connection.getDisplayName(), null, Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
        return null;
    }
}