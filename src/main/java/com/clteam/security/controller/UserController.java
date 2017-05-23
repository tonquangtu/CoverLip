package com.clteam.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Khanh Nguyen on 6/5/2017.
 */
@Controller
//@PreAuthorize("hasRole('ROLE_ADMIN') or hasROLE('ROLE_USER')")
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String index() {
        return "common/after_user_login";
    }

}
