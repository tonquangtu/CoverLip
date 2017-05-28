package com.clteam.controllers.lipsyncpagecontroller;

import com.clteam.dataconstant.DataConstant;
import com.clteam.model.ClientData;
import com.clteam.model.LipSync;
import com.clteam.model.TopIdol;
import com.clteam.model.VideoWrapper;
import com.clteam.services.commonservice.api.LipSyncService;
import com.clteam.services.commonservice.api.VideoService;
import com.clteam.services.userservice.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @Autowired
    LipSyncService lipSyncService;


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

            map.put("subBaseUrl", DataConstant.LIP_SYNC_BASE_URL);
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

    @RequestMapping(path = "hot-lip-sync/fetchdata")
    @ResponseBody
    public ClientData<VideoWrapper> fetchMoreHotLipSyncs(@RequestParam("lastVideoId") String lastVideoIdString,
                                                   @RequestParam("type") String type) {

        List<LipSync> hotLipSyncs = null;
        String message;
        int success = ClientData.SUCCESS;

        try {
            int limit = 9;
            if (lastVideoIdString != null && type != null) {

                int lastVideoId = Integer.parseInt(lastVideoIdString);
                hotLipSyncs = lipSyncService.getHotLipSyncsFrom(lastVideoId, limit);
            }
        }catch(Exception e) {

            hotLipSyncs = null;
            success = ClientData.ERROR;
            e.printStackTrace();
        }

        if (hotLipSyncs != null && hotLipSyncs.size() > 1) {
            message = ClientData.HAVE_DATA;
        } else {
            message = ClientData.NO_DATA;
        }

        ClientData<VideoWrapper> clientData = new ClientData<>();
        clientData.setResult(toVideoWrappers(hotLipSyncs));
        clientData.setMessage(message);
        clientData.setSuccess(success);

        return clientData;
    }

    public List<VideoWrapper> toVideoWrappers(List<LipSync> lipSyncs) {
        List<VideoWrapper> videoWrappers = new ArrayList<>();
        if (lipSyncs != null) {
            for (LipSync lipSync : lipSyncs) {
                videoWrappers.add(lipSync.toVideoWrapper());
            }
        }
        return videoWrappers;
    }


}
