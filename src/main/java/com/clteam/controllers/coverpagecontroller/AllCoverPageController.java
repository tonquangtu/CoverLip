package com.clteam.controllers.coverpagecontroller;

import com.clteam.model.Cover;
import com.clteam.model.TopList;
import com.clteam.model.VideoWrapper;
import com.clteam.services.commonservice.api.CoverService;
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
 * Created by mrgnu on 21/05/2017.
 */
@Controller
public class AllCoverPageController {

    @Autowired
    private CoverService coverService;
    @Autowired
    private TopIdolService topIdolService;

    @RequestMapping("/all-cover")
    public ModelAndView visitNewCoverPage(){

        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        List<Cover> coverList = coverService.getAllCover(9, -1);
        TopList<Cover> coverTopList = coverService.getListTopCover(0
        );

        List<VideoWrapper> videoWrapperList = new ArrayList<VideoWrapper>();
        for ( Cover cover: coverList) {
            videoWrapperList.add(cover.toVideoWrapper());
        }
        map.put("coverList", videoWrapperList);
        map.put("coverTopList", coverTopList);

        modelAndView.setViewName("coverpage/all_cover_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("/load_more_all_cover")
    public @ResponseBody
    List<VideoWrapper> loadMoreAllCoverPage(@RequestParam String currentVideoId,
                                     @RequestParam String limit){
        int currentVideoIdx = Integer.parseInt(currentVideoId);
        int limitx = Integer.parseInt(limit);
        List<VideoWrapper> videoWrapperList = new ArrayList<VideoWrapper>();
        List<Cover> coverList = coverService.getAllCover(limitx, currentVideoIdx);

        for ( Cover cover: coverList) {
            videoWrapperList.add(cover.toVideoWrapper());
        }
        System.out.println("fuck "+videoWrapperList.size());
        return videoWrapperList;
    }


}
