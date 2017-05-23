package com.clteam.security.controller;

import com.clteam.model.Cover;
import com.clteam.security.service.AdminCoverService;
import com.clteam.security.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Khanh Nguyen on 22/5/2017.
 */
@Controller
@RequestMapping("/admin/cover")
public class AdminCoverController {

    @Autowired
    private AdminCoverService adminCoverService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "1") String page) {
        int currentPage = 1;
        String redirectUrl = "redirect:/admin/cover/list?page=1";
        try {
            currentPage = Integer.parseInt(page);
        } catch (Exception e) {
            return redirectUrl;
        }
        if (currentPage <= 0) {
            return redirectUrl;
        }
        PaginationUtil<Cover> pagingCover = adminCoverService.pagingCover(currentPage);
        if (!pagingCover.isFound()) {
            return redirectUrl;
        } else {
            model.addAttribute("pagingCover", pagingCover);
            return "adminpage/cover/cover_list";
        }
    }

}
