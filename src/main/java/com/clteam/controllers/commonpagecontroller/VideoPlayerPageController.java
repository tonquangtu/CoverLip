package com.clteam.controllers.commonpagecontroller;

import com.clteam.dataconstant.DataConstant;
import com.clteam.model.*;
import com.clteam.repositories.api.TopRepository;
import com.clteam.security.util.AccountUtil;
import com.clteam.services.commonservice.api.RecommenderService;
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

    @Autowired
    TopIdolService topIdolService;

    @RequestMapping("cover/{videoInfoString}/{videoIdString}")
    public ModelAndView playCover (@PathVariable String videoInfoString, @PathVariable String videoIdString) {

        int accountId = AccountUtil.getCurrentUserId();
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

                map.put("subBaseUrl", DataConstant.COVER_BASE_URL);
                map.put("targetPage", DataConstant.COVER_PAGE);
                map.put("user", user);
                map.put("recommendationList", recommendationList);

                if (accountId > 0){
                    int checkFollow = topIdolService.checkFollowIdol(accountId, user.getAccount().getId());
                    map.put("checkFollow", checkFollow);
                }

                modelAndView.setViewName("commonpage/video_player_page");
            }else {
                modelAndView.setViewName("commonpage/error_page");
            }
        }catch(Exception e) {
            modelAndView.setViewName("commonpage/error_page");
            e.printStackTrace();
        }

        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("lipsync/{videoInfoString}/{videoIdString}")
    public ModelAndView playLipSync(@PathVariable String videoInfoString, @PathVariable String videoIdString) {

        int accountId = AccountUtil.getCurrentUserId();
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

                map.put("subBaseUrl", DataConstant.LIP_SYNC_BASE_URL);
                map.put("targetPage", DataConstant.LIP_SYNC_PAGE);
                map.put("user", user);
                map.put("recommendationList", recommendationList);

                if (accountId > 0){
                    int checkFollow = topIdolService.checkFollowIdol(accountId, user.getAccount().getId());
                    map.put("checkFollow", checkFollow);
                }
                modelAndView.setViewName("commonpage/video_player_page");
            }else {
                modelAndView.setViewName("commonpage/error_page");
            }
        }catch(Exception e) {
            modelAndView.setViewName("commonpage/error_page");
            e.printStackTrace();
        }

        modelAndView.addAllObjects(map);
        return modelAndView;
    }


    @RequestMapping(path = "video/update-view")
    @ResponseBody
    public ClientData updateNumView(@RequestParam("videoId") String videoId) {

        System.out.println("Update view for video:" + videoId);
        ClientData response = new ClientData();
        int videoIdInt;
        try {

            videoIdInt = Integer.parseInt(videoId);
            boolean updateSuccess = videoService.increaseVideoView(videoIdInt);
            int success = updateSuccess ? ClientData.SUCCESS : ClientData.ERROR;
            response.setSuccess(success);
            System.out.println("Success: " + success);
        }catch (Exception e) {
            response.setSuccess(ClientData.ERROR);
            e.printStackTrace();
        }

        return response;
    }


    @RequestMapping("menu")
    public ModelAndView testMenu() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test/menu1");
        return modelAndView;
    }


    @RequestMapping("menu1")
    public ModelAndView testMenu1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/main_header");
        return modelAndView;
    }
}
