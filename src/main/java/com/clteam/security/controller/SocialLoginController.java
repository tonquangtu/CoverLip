package com.clteam.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Khanh Nguyen on 11/5/2017.
 */
@Controller
public class SocialLoginController {

    @GetMapping("/signin")
    public String signin() {
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "common/afterLoginFacebook";
    }

}
