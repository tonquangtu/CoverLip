package com.clteam.security.controller;

import com.clteam.dataobject.HotCoverEntity;
import com.clteam.dataobject.NewCoverEntity;
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

    @GetMapping("/new-list")
    public String newList(Model model, @RequestParam(value = "page", defaultValue = "1") String page) {
        int currentPage = 1;
        String redirectUrl = "redirect:/admin/cover/new-list?page=1";
        try {
            currentPage = Integer.parseInt(page);
        } catch (Exception e) {
            return redirectUrl;
        }
        if (currentPage <= 0) {
            return redirectUrl;
        }
        PaginationUtil<NewCoverEntity> pagingCover = adminCoverService.pagingNewCover(currentPage);
        if (!pagingCover.isFound()) {
            return redirectUrl;
        } else {
            model.addAttribute("pagingCover", pagingCover);
            return "adminpage/cover/new_cover_list";
        }
    }

    @GetMapping("/hot-list")
    public String hotList(Model model, @RequestParam(value = "page", defaultValue = "1") String page) {
        int currentPage = 1;
        String redirectUrl = "redirect:/admin/cover/hot-list?page=1";
        try {
            currentPage = Integer.parseInt(page);
        } catch (Exception e) {
            return redirectUrl;
        }
        if (currentPage <= 0) {
            return redirectUrl;
        }
        PaginationUtil<HotCoverEntity> pagingCover = adminCoverService.pagingHotCover(currentPage);
        if (!pagingCover.isFound()) {
            return redirectUrl;
        } else {
            model.addAttribute("pagingCover", pagingCover);
            return "adminpage/cover/hot_cover_list";
        }
    }

}
