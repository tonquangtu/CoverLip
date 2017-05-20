package com.clteam.controllers.lipsyncpagecontroller;

import com.clteam.model.LipSync;
import com.clteam.model.TopIdol;
import com.clteam.model.VideoWrapper;
import com.clteam.services.commonservice.api.VideoService;
import com.clteam.services.userservice.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dell on 16-May-17.
 */

@Controller
public class LipSyncHomePageController {

    @Autowired
    VideoService videoService;

    @Autowired
    private UserService userService;


    @RequestMapping("lipsync")
    public ModelAndView visitLipSyncHomePage() {

        ModelAndView modelAndView = new ModelAndView();
        try {

            int limitLipSync = 12;
            int limitIdol = 9;
            List<LipSync> hotLipSyncs = videoService.getHotLipSyncs(limitLipSync);
            List<VideoWrapper> videoWrappers = toVideoWrappers(hotLipSyncs);
            List<TopIdol> topIdols = userService.getLipSyncIdols(limitIdol);

            Map<String, Object> map = new HashMap<>();
            map.put("topIdolList", topIdols);
            map.put("hotLipSyncs", videoWrappers);
            modelAndView.addAllObjects(map);
            modelAndView.setViewName("lipsyncpage/lip_sync_home_page");

        }catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("commonpage/error_page");
        }

        return modelAndView;
    }

    @RequestMapping("hot-lipsync/fetchdata")
    public List<VideoWrapper> fetchMoreLipSyncs() {



    }

    public List<VideoWrapper> toVideoWrappers(List<LipSync> lipSyncs) {
        List<VideoWrapper> videoWrappers = new ArrayList<>();
        for (LipSync lipSync : lipSyncs) {
            videoWrappers.add(lipSync.toVideoWrapper());
        }
        return videoWrappers;
    }


}
