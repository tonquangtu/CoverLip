package com.clteam.controllers.lipsyncpagecontroller;

import com.clteam.model.Cover;
import com.clteam.model.LipSync;
import com.clteam.model.VideoWrapper;
import com.clteam.services.commonservice.api.LipSyncService;
import com.clteam.services.commonservice.api.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyenthanhtung on 29/05/2017.
 */
@Controller
public class HotLipSyncController {
    @Autowired
    VideoService videoService;
    @RequestMapping("/hot-lip-sync/json")
    public @ResponseBody
    List getHotCover(@RequestParam String limit){
        int limitx = Integer.parseInt(limit);
        List<LipSync> hotLipSyncList = videoService.getHotLipSyncs(limitx);
        List<VideoWrapper> videoWrapperList = new ArrayList<VideoWrapper>();
        for ( LipSync lipSync: hotLipSyncList) {
            videoWrapperList.add(lipSync.toVideoWrapper());
        }
        return videoWrapperList;
    }
}
