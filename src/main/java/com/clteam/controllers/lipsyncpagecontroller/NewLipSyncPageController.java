package com.clteam.controllers.lipsyncpagecontroller;

import com.clteam.model.*;
import com.clteam.services.commonservice.api.CoverService;
import com.clteam.services.commonservice.api.LipSyncService;
import com.clteam.services.userservice.api.TopIdolService;
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
 * Created by mrgnu on 22/05/2017.
 */
@Controller
public class NewLipSyncPageController {

    @Autowired
    private LipSyncService lipSyncService;
    @Autowired
    private TopIdolService topIdolService;
    @Autowired
    private UserService userService;

    @RequestMapping("/new-lipsync")
    public ModelAndView visitNewLipSyncPage(){

        int accountId = 3;
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        List<LipSync> newLipSyncList = lipSyncService.getListNewLipSync(-1);
        List<TopIdol> listTopLipSyncIdols = topIdolService.getListTopLipSyncIdols(6);

        List<VideoWrapper> videoWrapperList = new ArrayList<VideoWrapper>();
        for ( LipSync lipSync: newLipSyncList) {
            videoWrapperList.add(lipSync.toVideoWrapper());
        }
        map.put("newLipSyncList", videoWrapperList);
        map.put("listTopLipSyncIdols", listTopLipSyncIdols);

        if (accountId > 0){
            FollowingList userList = userService.getIdolOfUser(accountId, -1, -1);
            if (userList == null) {
                modelAndView.setViewName("commonpage/error_page");
            } else {
                map.put("idolList", userList.getFollowings());
            }
        }

        modelAndView.setViewName("lipsyncpage/new_lip_sync_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
