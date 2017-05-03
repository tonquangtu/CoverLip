package com.clteam.controllers.usercontroller;

import com.clteam.model.Cover;
import com.clteam.model.TopIdol;
import com.clteam.services.userservice.api.HotCoverService;
import com.clteam.services.userservice.api.NewCoverService;
import com.clteam.services.userservice.api.TopIdolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nguyenthanhtung on 29/04/2017.
 */
@Controller
public class HomeCoverPageController {
    @Autowired
    private NewCoverService newCoverService;
    @Autowired
    private HotCoverService hotCoverService;
    @Autowired
    private TopIdolService topIdolService;
    @RequestMapping("/")
    public ModelAndView visitHomeCoverPage(){
        List<Cover> newCoverList = newCoverService.getListNewCover(12);
        List<Cover> hotCoverList = hotCoverService.getListHotCover(12);
        List<TopIdol> topIdolList = topIdolService.getListTopIdol();
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("size "+newCoverList.size());
        map.put("newCoverList", newCoverList);
        map.put("hotCoverList", hotCoverList);
        map.put("topIdolList", topIdolList);
        modelAndView.setViewName("homecoverpage/home_cover_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("/top-cover")
    public ModelAndView visitTopCoverPage(){
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();
        modelAndView.setViewName("topcoverpage/top_cover_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
