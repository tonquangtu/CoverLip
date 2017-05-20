package com.clteam.controllers.usercontroller;

import com.clteam.model.*;
import com.clteam.services.commonservice.api.RecommenderService;
import com.clteam.services.commonservice.api.VideoService;
import com.clteam.services.userservice.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Dell on 28-Apr-17.
 */

@Controller
public class VideoPlayerPageController {

    @Autowired
    VideoService videoService;

    @Autowired
    UserService userService;

    @Autowired
    RecommenderService recommenderService;

    @RequestMapping("cover/{singerName}/{songName}/{videoIdString}")
    public ModelAndView playCover(@PathVariable String singerName,
                                             @PathVariable String songName,
                                             @PathVariable String videoIdString) {

        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int videoId = Integer.parseInt(videoIdString);
            Cover currCover = videoService.getCoverInfo(videoId);

            if (currCover != null) {

                map.put("currItem", currCover.toVideoWrapper());
                Account ownerAccount = currCover.getVideo().getAccount();
                User user = null;
                if (ownerAccount != null) {
                    user = userService.getUser(ownerAccount.getId());

                }

                List<VideoWrapper> recommendationList = new ArrayList<>();
                List<Cover> recommendationCoverList = recommenderService.recommendCovers(currCover, null, 6);

                if (recommendationCoverList != null) {

                    for (Cover item : recommendationCoverList) {
                        recommendationList.add(item.toVideoWrapper());
                    }
                }


                map.put("user", user);
                map.put("recommendationList", recommendationList);
                modelAndView.setViewName("commonpage/video_player_page");
            }else {
                modelAndView.setViewName("common/error");
            }
        }catch(Exception e) {
            modelAndView.setViewName("common/error");
            e.printStackTrace();
        }

        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("lipsync/{singerName}/{songName}/{videoIdString}")
    public ModelAndView playLipSync(@PathVariable String singerName,
                                             @PathVariable String songName,
                                             @PathVariable String videoIdString) {

        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            int videoId = Integer.parseInt(videoIdString);
            LipSync currLipSync = videoService.getLipSync(videoId);

            if (currLipSync != null) {

                map.put("currItem", currLipSync.toVideoWrapper());
                Account ownerAccount = currLipSync.getVideo().getAccount();
                User user = null;
                if (ownerAccount != null) {
                    user = userService.getUser(ownerAccount.getId());
                }

                List<VideoWrapper> recommendationList = new ArrayList<>();
                List<LipSync> recommendationLSList = recommenderService.recommendLipSyncs(currLipSync, null, 6);
                if (recommendationLSList != null) {
                    for (LipSync item : recommendationLSList) {
                        recommendationList.add(item.toVideoWrapper());
                    }
                }

                map.put("user", user);
                map.put("recommendationList", recommendationList);
                modelAndView.setViewName("commonpage/video_player_page");
            }else {
                modelAndView.setViewName("common/error");
            }
        }catch(Exception e) {
            modelAndView.setViewName("common/error");
            e.printStackTrace();
        }

        modelAndView.addAllObjects(map);
        return modelAndView;
    }



}
