package com.clteam.controllers.coverpagecontroller;

import com.clteam.model.Cover;
import com.clteam.model.FollowingList;
import com.clteam.model.TopIdol;
import com.clteam.model.VideoWrapper;
import com.clteam.services.commonservice.api.CoverService;
import com.clteam.services.userservice.api.TopIdolService;
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
 * Created by mrgnu on 29/04/2017.
 */
@Controller
public class HotCoverPageController {

    @Autowired
    private CoverService coverService;
    @Autowired
    private TopIdolService topIdolService;
    @Autowired
    private UserService userService;

    @RequestMapping("/hot-cover")
    public ModelAndView visitHotCoverPage(){

        int accountId = 3;
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        List<Cover> hotCoverList = coverService.getListHotCover(-1);
        List<TopIdol> listTopCoverIdols = topIdolService.getListTopCoverIdols(10);
        List<VideoWrapper> videoWrapperList = new ArrayList<VideoWrapper>();
        for ( Cover cover: hotCoverList) {
            videoWrapperList.add(cover.toVideoWrapper());
        }
        map.put("hotCoverList", videoWrapperList);
        map.put("listTopCoverIdols", listTopCoverIdols);

        if (accountId > 0){
            FollowingList userList = userService.getIdolOfUser(accountId, -1, -1);
            if (userList == null) {
                modelAndView.setViewName("commonpage/error_page");
            } else {
                map.put("idolList", userList.getFollowings());
            }
        }

        modelAndView.setViewName("coverpage/hot_cover_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("/hot-cover/json")
    public @ResponseBody List getHotCover(@RequestParam String limit){
        int limitx = Integer.parseInt(limit);
        List<Cover> hotCoverList = coverService.getListHotCover(limitx);
        List<VideoWrapper> videoWrapperList = new ArrayList<VideoWrapper>();
        for ( Cover cover: hotCoverList) {
            videoWrapperList.add(cover.toVideoWrapper());
        }
        return videoWrapperList;
    }
}
