package com.clteam.security.util;

import com.clteam.security.model.CustomSocialUser;
import com.clteam.security.model.CustomUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Khanh Nguyen on 23/5/2017.
 */
public class AccountUtil {

    public static UserDetails getCurrentUserDetails() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //a null check is not needed before using instanceof, if null instance of SomeClass always return false
        if (principal instanceof CustomUser) {
            return (CustomUser) principal;
        } else if (principal instanceof CustomSocialUser){
            return (CustomSocialUser) principal;
        }
        return null;
    }

    public static int getCurrentUserId() {
        UserDetails userDetails = getCurrentUserDetails();
        if (userDetails instanceof CustomUser) {
            return ((CustomUser) userDetails).getAccountEntity().getId();
        } else if (userDetails instanceof CustomSocialUser){
            return ((CustomSocialUser) userDetails).getAccountEntity().getId();
        }
        return -1;
    }

}
