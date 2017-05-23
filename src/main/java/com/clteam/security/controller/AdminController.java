package com.clteam.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Khanh Nguyen on 6/5/2017.
 */
@Controller
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public String index() {
        return "redirect:/admin/account/list";
    }

//    @GetMapping("/account/list")
//    public String list() {
//        return "adminpage/account/list";
//    }

}
