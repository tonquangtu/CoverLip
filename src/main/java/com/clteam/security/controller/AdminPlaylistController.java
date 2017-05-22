package com.clteam.security.controller;

import com.clteam.model.Playlist;
import com.clteam.security.service.AdminPlaylistService;
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
@RequestMapping("/admin/playlist")
public class AdminPlaylistController {

    @Autowired
    private AdminPlaylistService adminPlaylistService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "1") String page) {
        int currentPage = 1;
        String redirectUrl = "redirect:/admin/playlist/list?page=1";
        try {
            currentPage = Integer.parseInt(page);
        } catch (Exception e) {
            return redirectUrl;
        }
        if (currentPage <= 0) {
            return redirectUrl;
        }
        PaginationUtil<Playlist> pagingCover = adminPlaylistService.pagingPlaylist(currentPage);
        if (!pagingCover.isFound()) {
            return redirectUrl;
        } else {
            model.addAttribute("pagingPlaylist", pagingCover);
            return "adminpage/playlist/playlist_list";
        }
    }

}
