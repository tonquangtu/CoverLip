package com.clteam.security.controller;

import com.clteam.security.service.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Khanh Nguyen on 21/5/2017.
 */
@Controller
@RequestMapping("/admin/account")
public class AdminAccountController {

    @Autowired
    private AdminAccountService adminAccountService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("userList", adminAccountService.findAllUser());
        return "adminpage/account/list";
    }

}
