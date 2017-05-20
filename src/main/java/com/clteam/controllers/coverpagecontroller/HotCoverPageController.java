package com.clteam.controllers.coverpagecontroller;

import com.clteam.model.Cover;
import com.clteam.model.TopIdol;
import com.clteam.model.VideoWrapper;
import com.clteam.services.commonservice.api.CoverService;
import com.clteam.services.userservice.api.TopIdolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/hot-cover")
    public ModelAndView visitHotCoverPage(){

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

        modelAndView.setViewName("coverpage/hot_cover_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
