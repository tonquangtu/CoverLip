package com.clteam.security.controller;

import com.clteam.model.User;
import com.clteam.security.service.AdminAccountService;
import com.clteam.security.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Khanh Nguyen on 21/5/2017.
 */
@Controller
@RequestMapping("/admin/account")
public class AdminAccountController {

    @Autowired
    private AdminAccountService adminAccountService;

//    @GetMapping("/list")
//    public String list(Model model) {
//        model.addAttribute("userList", adminAccountService.findAllUser());
//        return "adminpage/account/list";
//    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "1") String page) {
        int currentPage = 1;
        String redirectUrl = "redirect:/admin/account/list?page=1";
        try {
            currentPage = Integer.parseInt(page);
        } catch (Exception e) {
            return redirectUrl;
        }
        if (currentPage <= 0) {
            return redirectUrl;
        }
        PaginationUtil<User> pagingUser = adminAccountService.pagingUser(currentPage);
        if (!pagingUser.isFound()) {
            return redirectUrl;
        } else {
            model.addAttribute("pagingUser", pagingUser);
            return "adminpage/account/list";
        }
    }

}
