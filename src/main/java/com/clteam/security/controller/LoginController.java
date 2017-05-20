package com.clteam.security.controller;

import com.clteam.security.constant.SecurityConstant;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * Created by Khanh Nguyen on 5/5/2017.
 */
@Controller
public class LoginController {

//    @GetMapping("/")
//    public String index() {
//        return "redirect:/login";
//    }

    @GetMapping("/login")
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            boolean authorized = authorities.contains(new SimpleGrantedAuthority(SecurityConstant.ROLE_ADMIN_STR));
            if (authorized) {
                return "redirect:/admin";
            } else {
                return "redirect:/user";
            }
        }
        return "common/login";
    }

}
