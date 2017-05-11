package com.clteam.controllers.usercontroller;

import com.clteam.model.Account;
import com.clteam.model.Cover;
import com.clteam.model.LipSync;
import com.clteam.model.User;
import com.clteam.services.commonservice.api.RecommenderService;
import com.clteam.services.commonservice.api.VideoService;
import com.clteam.services.userservice.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView visitVideoPlayerPage(@PathVariable String singerName,
                                             @PathVariable String songName,
                                             @PathVariable String videoIdString) {

        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int videoId = Integer.parseInt(videoIdString);
            Cover cover = videoService.getCoverInfo(videoId);

            if (cover != null) {

                map.put("cover", cover);
                Account ownerAccount = cover.getVideo().getAccount();
                User user = null;
                if (ownerAccount != null) {
                    user = userService.getUser(ownerAccount.getId());

                }
                List<Cover> recommendationList = recommenderService.recommendCovers(cover, null, 6);
                map.put("user", user);
                map.put("recommendationList", recommendationList);
                modelAndView.setViewName("videoplayerpage/video_player_page");
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
    public ModelAndView test(@PathVariable String singerName,
                                             @PathVariable String songName,
                                             @PathVariable String videoIdString) {

        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            int videoId = Integer.parseInt(videoIdString);
            LipSync currLipSync = videoService.getLipSync(videoId);

            if (currLipSync != null) {

                map.put("lipSync", currLipSync);
                Account ownerAccount = currLipSync.getVideo().getAccount();
                User user = null;
                if (ownerAccount != null) {
                    user = userService.getUser(ownerAccount.getId());

                }
                List<LipSync> recommendationList = recommenderService.recommendLipSyncs(currLipSync, null, 6);
                map.put("user", user);
                map.put("recommendationList", recommendationList);
                modelAndView.setViewName("common/error");
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
