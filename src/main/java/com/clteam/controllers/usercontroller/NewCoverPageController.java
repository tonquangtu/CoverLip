package com.clteam.controllers.usercontroller;

import com.clteam.model.Cover;
import com.clteam.model.TopIdol;
import com.clteam.services.commonservice.api.CoverService;
import com.clteam.services.userservice.api.TopIdolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrgnu on 19/05/2017.
 */
@Controller
public class NewCoverPageController {

    @Autowired
    private CoverService coverService;
    @Autowired
    private TopIdolService topIdolService;

    @RequestMapping("/new-cover")
    public ModelAndView visitNewCoverPage(){

        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        List<Cover> newCoverList = coverService.getListNewCover(5, -1);
        List<TopIdol> listTopCoverIdols = topIdolService.getListTopCoverIdols(10);

        map.put("newCoverList", newCoverList);
        map.put("listTopCoverIdols", listTopCoverIdols);

        modelAndView.setViewName("coverpage/new_cover_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("/load_more_new_cover")
    public @ResponseBody
    List<Cover> loadMoreNewCover(@RequestParam String currentVideoId,
                                 @RequestParam String limit){

        System.out.println("trung " + currentVideoId);
        int currentVideoIdx = Integer.parseInt(currentVideoId);
        int limitx = Integer.parseInt(limit);
        List<Cover> newCoverList = coverService.getListNewCover(limitx, currentVideoIdx);

        return newCoverList;
    }
}
