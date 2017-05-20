package com.clteam.controllers.coverpagecontroller;

import com.clteam.model.Cover;
import com.clteam.model.Playlist;
import com.clteam.model.TopIdol;
import com.clteam.model.TopList;
import com.clteam.services.commonservice.api.CoverService;
import com.clteam.services.userservice.api.TopIdolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nguyenthanhtung on 03/05/2017.
 */
@Controller
public class TopCoverPageController {
    @Autowired
    private CoverService coverService;
    @Autowired
    private TopIdolService topIdolService;
    @RequestMapping("/top-cover")
    public ModelAndView visitTopCoverPage(){
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        List<Playlist> playlistList = coverService.getListPlayListCover(-1);
        List<TopIdol> topIdolList = topIdolService.getListTopCoverIdols(5);
        TopList<Cover> coverTopList = coverService.getListTopCover();

        if(playlistList==null || topIdolList==null ||coverTopList==null){
            modelAndView.setViewName("commonpage/error_page");
        }else{
            map.put("hotPlayListCover", playlistList);
            map.put("topIdolList", topIdolList);
            map.put("coverTopList", coverTopList);
            modelAndView.setViewName("coverpage/top_cover_page");
        }
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
