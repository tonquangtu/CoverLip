package com.clteam.controllers.coverpagecontroller;

import com.clteam.model.*;
import com.clteam.services.commonservice.api.CoverService;
import com.clteam.services.commonservice.api.VideoService;
import com.clteam.services.userservice.api.TopIdolService;
import com.clteam.services.userservice.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

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
    @Autowired
    private VideoService videoService;

    @RequestMapping("/")
    public ModelAndView visitHomeCoverPage(HttpServletResponse response) {
        List<Cover> newCoverList = coverService.getListNewCover(12);
        List<Cover> hotCoverList = coverService.getListHotCover(12);
        List<TopIdol> topIdolList = topIdolService.getListTopCoverIdols(9);
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();
        List<VideoWrapper> newCoverWrapperList = new ArrayList<>();
        for(Cover cover:newCoverList){
            newCoverWrapperList.add(cover.toVideoWrapper());
        }
        List<VideoWrapper> hotCoverWrapperList = new ArrayList<>();
        for(Cover cover:hotCoverList){
            hotCoverWrapperList.add(cover.toVideoWrapper());
        }
        map.put("newCoverList", newCoverWrapperList);
        map.put("hotCoverList", hotCoverWrapperList);
        map.put("topIdolList", topIdolList);
        modelAndView.setViewName("coverpage/home_cover_page");
        modelAndView.addAllObjects(map);


        //Gia lap cookie sau khi login
        response.addCookie(new Cookie("myaccount", ""+userService.getUser(8).getAccount().getId()));

        //
        return modelAndView;
    }

    @RequestMapping("/personal")
    public String visitPersonalInfomationPage(){
        return "redirect:/personal/information";
    }
    @RequestMapping("/personal/{type}")
    public ModelAndView visitPersonalInfomationPage(@PathVariable String type, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("type", type);
        //Get id personal from cookie
        Cookie cookie = WebUtils.getCookie(request, "myaccount");
        int accountId = Integer.parseInt(cookie.getValue());
        User user = userService.getUser(accountId);
        map.put("userInfo",user);
        //

        List<VideoWrapper> videoWrapperList = new ArrayList<>();
        if(Objects.equals(type, "information")){

        }else if(Objects.equals(type, "change-password")){

        }else if(Objects.equals(type, "my-cover")){
            List<Cover> coverOfUserList = coverService.getListCoverOfUser(accountId, 6, -1);
            for(Cover cover:coverOfUserList){
                videoWrapperList.add(cover.toVideoWrapper());
            }
            map.put("videoList", videoWrapperList);
        }else if(Objects.equals(type, "my-lipsync")){
            List<LipSync> lipSyncOfUserList = videoService.getListLipSyncOfUser(accountId,6,-1);
            for(LipSync lipSync:lipSyncOfUserList){
                videoWrapperList.add(lipSync.toVideoWrapper());
            }
            map.put("videoList", videoWrapperList);
        }else if(Objects.equals(type,"my-playlist")){

        }else if(Objects.equals(type, "my-idol")){

        }else if(Objects.equals(type, "my-fan")){

        }
        modelAndView.setViewName("commonpage/personal_page");
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
        List<VideoWrapper> videoWrapperList = new ArrayList<>();
        if(Objects.equals(type, "cover")){
            List<Cover> coverOfUserList = coverService.getListCoverOfUser(accountId, 4, -1);
            List<TopIdol> topIdolList = topIdolService.getListTopCoverIdols(5);
            for(Cover cover:coverOfUserList){
                videoWrapperList.add(cover.toVideoWrapper());
            }
            map.put("videoList", videoWrapperList);
            map.put("topIdolList", topIdolList);
        }else if(Objects.equals(type, "lipsync")){
            List<LipSync> lipSyncOfUserList = videoService.getListLipSyncOfUser(accountId, 4, -1);
            List<TopIdol> topIdolList = topIdolService.getListTopCoverIdols(5);
            for(LipSync lipSync:lipSyncOfUserList){
                videoWrapperList.add(lipSync.toVideoWrapper());
            }
            map.put("videoList", videoWrapperList);
            map.put("topIdolList", topIdolList);
        }
        modelAndView.setViewName("commonpage/user_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("/user")
    public @ResponseBody
    List<VideoWrapper> getMoreCoverOfUser(@RequestParam String accountId,
                                   @RequestParam String currentVideoId,
                                   @RequestParam String limit,
                                   @RequestParam String type) {
        int accountIdx = Integer.parseInt(accountId);
        int currentVideoIdx = Integer.parseInt(currentVideoId);
        int limitx = Integer.parseInt(limit);
        List<VideoWrapper> videoWrapperList = new ArrayList<>();
        if(Objects.equals(type, "cover")){
            List<Cover> coverOfUserList = coverService.getListCoverOfUser(accountIdx, limitx,currentVideoIdx);
            for(Cover cover:coverOfUserList){
                videoWrapperList.add(cover.toVideoWrapper());
            }
        }else if(Objects.equals(type, "lipsync")){
            List<LipSync> lipSyncOfUserList = videoService.getListLipSyncOfUser(accountIdx, limitx, currentVideoIdx);
            for(LipSync lipSync:lipSyncOfUserList){
                videoWrapperList.add(lipSync.toVideoWrapper());
            }
        }

        return videoWrapperList;
    }
}
