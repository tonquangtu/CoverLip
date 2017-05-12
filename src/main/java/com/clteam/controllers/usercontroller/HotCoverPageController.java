package com.clteam.controllers.usercontroller;

import com.clteam.dataobject.TopCoverIdolEntity;
import com.clteam.model.Cover;
import com.clteam.model.TopIdol;
import com.clteam.services.userservice.api.HotCoverService;
import com.clteam.services.userservice.api.TopIdolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrgnu on 29/04/2017.
 */
@Controller
public class HotCoverPageController {

    @Autowired
    private HotCoverService hotCoverService;
    @Autowired
    private TopIdolService topIdolService;

    @RequestMapping("/hot-cover")
    public ModelAndView visitHotCoverPage(){

        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        List<Cover> hotCoverList = hotCoverService.getListHotCover(-1);
        List<TopIdol> listTopCoverIdols = topIdolService.getListTopCoverIdols(10);

        System.out.println(listTopCoverIdols.get(0).getUser().getAccount().getFullname());

        map.put("hotCoverList", hotCoverList);
        map.put("listTopCoverIdols", listTopCoverIdols);

        modelAndView.setViewName("hotcoverpage/hot_cover_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
