package com.clteam.controllers.usercontroller;

import com.clteam.model.FullCoverInfo;
import com.clteam.services.userservice.api.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Dell on 28-Apr-17.
 */

@Transactional
@Controller
public class VideoPlayerPageController {

    @Autowired
    VideoService videoService;

    @RequestMapping("cover/{singerName}/{songName}/{videoIdString}")
    public ModelAndView visitVideoPlayerPage(@PathVariable String singerName,
                                             @PathVariable String songName,
                                             @PathVariable String videoIdString) {

        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            long videoId = Integer.parseInt(videoIdString);
            FullCoverInfo fullCoverInfo = videoService.getFullCoverInfo(videoId);
            if (fullCoverInfo != null) {

                map.put("fullCoverInfo", fullCoverInfo);
                modelAndView.addAllObjects(map);
                modelAndView.setViewName("videoplayerpage/video_player_page");
            }
        }catch(Exception e) {
            modelAndView.setViewName("common/error");
        }
        return modelAndView;
    }


}
