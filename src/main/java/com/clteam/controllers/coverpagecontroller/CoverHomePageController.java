package com.clteam.controllers.coverpagecontroller;

import com.clteam.model.Cover;
import com.clteam.model.TopIdol;
import com.clteam.model.User;
import com.clteam.services.commonservice.api.CoverService;
import com.clteam.services.userservice.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by nguyenthanhtung on 29/04/2017.
 */
@Controller
public class CoverHomePageController {
    @Autowired
    private UserService userService;
    @Autowired
    private TopIdolService topIdolService;
    @Autowired
    private CoverService coverService;

    @RequestMapping("/")
    public ModelAndView visitHomeCoverPage() {
        List<Cover> newCoverList = coverService.getListNewCover(12);
        List<Cover> hotCoverList = coverService.getListHotCover(12);
        List<TopIdol> topIdolList = topIdolService.getListTopCoverIdols(9);
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("size " + newCoverList.size());
        map.put("newCoverList", newCoverList);
        map.put("hotCoverList", hotCoverList);
        map.put("topIdolList", topIdolList);
        modelAndView.setViewName("coverpage/home_cover_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }


    @RequestMapping("/persional-setting")
    public ModelAndView visitPersionalInfomationPage() {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        modelAndView.setViewName("commonpage/persional_infomation_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("user/{idUser}")
    public String visitUserPage(@PathVariable String idUser){
        return "redirect: /user/"+idUser+"/cover";
    }

    @RequestMapping("/user/{idUser}/{type}")
    public ModelAndView visitUserPage(@PathVariable String idUser, @PathVariable String type) {
        int accountId = Integer.parseInt(idUser);
        User user = userService.getUser(accountId);
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userInfo", user);
        map.put("type", type);
        if(Objects.equals(type, "cover")){
            List<Cover> coverOfUserList = coverService.getListCoverOfUser(accountId, 4, -1);
            List<TopIdol> topIdolList = topIdolService.getListTopCoverIdols(5);
            map.put("videoList", coverOfUserList);
            map.put("topIdolList", topIdolList);
        }else if(Objects.equals(type, "lipsync")){

            //Edit here........
            List<Cover> lipSyncOfUserList = null;
            List<TopIdol> topIdolList = null;
            map.put("videoList", lipSyncOfUserList);
            map.put("topIdolList", topIdolList);
        }

        modelAndView.setViewName("commonpage/user_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("/user")
    public @ResponseBody
    List<Cover> getMoreVideoOfUser(@RequestParam String accountId,
                                   @RequestParam String currentVideoId,
                                   @RequestParam String limit,
                                   @RequestParam String type) {
        int accountIdx = Integer.parseInt(accountId);
        int currentVideoIdx = Integer.parseInt(currentVideoId);
        int limitx = Integer.parseInt(limit);

        if(Objects.equals(type, "cover")){
            List<Cover> coverOfUserList = coverService.getListCoverOfUser(accountIdx, limitx,currentVideoIdx);
            return coverOfUserList;
        }
        return null;
    }
}
