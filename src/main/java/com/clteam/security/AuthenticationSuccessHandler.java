package com.clteam.security;


import com.clteam.security.constant.SecurityConstant;
import com.clteam.security.model.CustomSocialUser;
import com.clteam.security.model.CustomUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

/**
 * Created by Khanh Nguyen on 6/5/2017.
 */
@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("### login success handler");
        HttpSession session = request.getSession();
//        if (session != null ) {
//            // System.out.println("### set timeout for session, default is: " + session.getMaxInactiveInterval());
//            // set timeout for session (unit: seconds), default timeout is 30 minutes (1800 seconds)
//            // set timeout = 20 minutes
//            session.setMaxInactiveInterval(20 * 60);
//        }

        Object principal = authentication.getPrincipal();
        int state = -1;
        if (principal instanceof CustomUser) {
            state = ((CustomUser) principal).getState();
        } else if (principal instanceof CustomSocialUser) {
            state = ((CustomSocialUser) principal).getState();
        }

        if (state == SecurityConstant.ACCOUNT_ACTIVATED_INT) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            boolean authorized = authorities.contains(new SimpleGrantedAuthority(SecurityConstant.ROLE_ADMIN_STR));
            if (authorized) {
                setDefaultTargetUrl(SecurityConstant.TARGET_ADMIN_URL);
                session.setMaxInactiveInterval(SecurityConstant.ADMIN_SESSION_TIMEOUT);
            } else {
                setDefaultTargetUrl(SecurityConstant.TARGET_USER_URL);
                session.setMaxInactiveInterval(SecurityConstant.USER_SESSION_TIMEOUT);
            }
        } else {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            response.sendRedirect(SecurityConstant.NON_ACTIVATE_URL);
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
