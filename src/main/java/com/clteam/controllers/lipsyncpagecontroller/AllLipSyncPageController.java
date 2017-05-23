package com.clteam.controllers.lipsyncpagecontroller;

import com.clteam.model.LipSync;
import com.clteam.model.TopIdol;
import com.clteam.model.VideoWrapper;
import com.clteam.services.commonservice.api.LipSyncService;
import com.clteam.services.userservice.api.TopIdolService;
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
 * Created by mrgnu on 22/05/2017.
 */
@Controller
public class AllLipSyncPageController {

    @Autowired
    private LipSyncService lipSyncService;
    @Autowired
    private TopIdolService topIdolService;

    @RequestMapping("/all-lipsync")
    public ModelAndView visitNewLipSyncPage(){

        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        List<LipSync> lipSyncList = lipSyncService.getListLipSync(9, -1);
        List<TopIdol> listTopLipSyncIdols = topIdolService.getListTopLipSyncIdols(6);

        List<VideoWrapper> videoWrapperList = new ArrayList<VideoWrapper>();
        for ( LipSync lipSync: lipSyncList) {
            videoWrapperList.add(lipSync.toVideoWrapper());
        }
        map.put("lipSyncList", videoWrapperList);
        map.put("listTopLipSyncIdols", listTopLipSyncIdols);

        modelAndView.setViewName("lipsyncpage/all_lip_sync_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("/load_more_all_lipsync")
    public @ResponseBody
    List<VideoWrapper> loadMoreAllLipSyncPage(@RequestParam String currentVideoId,
                                     @RequestParam String limit){
        int currentVideoIdx = Integer.parseInt(currentVideoId);
        int limitx = Integer.parseInt(limit);
        List<VideoWrapper> videoWrapperList = new ArrayList<VideoWrapper>();
        List<LipSync> lipSyncList = lipSyncService.getListLipSync(limitx, currentVideoIdx);

        for ( LipSync lipSync: lipSyncList) {
            videoWrapperList.add(lipSync.toVideoWrapper());
        }

        return videoWrapperList;
    }
}
