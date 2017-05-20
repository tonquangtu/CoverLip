package com.clteam.controllers.lipsyncpagecontroller;

import com.clteam.model.TopIdol;
import com.clteam.services.userservice.api.TopIdolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dell on 16-May-17.
 */

@Controller
public class LipSyncHomePageController {


    @Autowired
    private TopIdolService topIdolService;


    @RequestMapping("lipsync")
    public ModelAndView visitLipSyncHomePage() {

        ModelAndView modelAndView = new ModelAndView();
        List<TopIdol> topIdolList = topIdolService.getListTopCoverIdols(9);

        Map<String, Object> map = new HashMap<>();

        map.put("topIdolList", topIdolList);
        modelAndView.addAllObjects(map);
        modelAndView.setViewName("lipsyncpage/lip_sync_home_page");
        return modelAndView;
    }






}
