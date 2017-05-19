package com.clteam.controllers.coverpagecontroller;

import com.clteam.model.Cover;
import com.clteam.model.Playlist;
import com.clteam.model.TopIdol;
import com.clteam.model.User;
import com.clteam.services.commonservice.api.CoverService;
import com.clteam.services.userservice.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nguyenthanhtung on 29/04/2017.
 */
@Controller
public class CoverHomePageController {


    @Autowired
    CoverService coverService;

    @Autowired
    private UserService userService;

    @Autowired
    private TopIdolService topIdolService;

    @RequestMapping("/")
    public ModelAndView visitHomeCoverPage(){
        List<Cover> newCoverList = coverService.getListNewCover(12);
        List<Cover> hotCoverList = coverService.getListHotCover(12);
        List<TopIdol> topIdolList = topIdolService.getListTopCoverIdols(9);
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("size "+newCoverList.size());
        map.put("newCoverList", newCoverList);
        map.put("hotCoverList", hotCoverList);
        map.put("topIdolList", topIdolList);
        modelAndView.setViewName("coverpage/home_cover_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("/top-cover")
    public ModelAndView visitTopCoverPage(){
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        List<Playlist> playlistList = coverService.getListPlayListCover(-1);
        List<TopIdol> topIdolList = topIdolService.getListTopCoverIdols(5);
        map.put("hotPlayListCover", playlistList);
        map.put("topIdolList", topIdolList);
        modelAndView.setViewName("coverpage/top_cover_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("/persional-setting")
    public ModelAndView visitPersionalInfomationPage(){
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        modelAndView.setViewName("commonpage/persional_infomation_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
    @RequestMapping("/user/{idUser}")
    public ModelAndView visitUserPage(@PathVariable String idUser){
        int accountId = Integer.parseInt(idUser);
        User user = userService.getUser(accountId);
        List<Cover> newCoverList = coverService.getListNewCover(12);
        List<Cover> hotCoverList = coverService.getListHotCover(12);
        List<TopIdol> topIdolList = topIdolService.getListTopCoverIdols(5);
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("size "+newCoverList.size());
        map.put("userInfo", user);
        map.put("newCoverList", newCoverList);
        map.put("hotCoverList", hotCoverList);
        map.put("topIdolList", topIdolList);
        modelAndView.setViewName("commonpage/user_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}