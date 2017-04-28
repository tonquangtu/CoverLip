package com.clteam.controllers.usercontroller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

    @RequestMapping("cover")
    public ModelAndView visitVideoPlayerPage() {

        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();
        modelAndView.setViewName("videoplayerpage/video_player_page");
        return modelAndView;
    }


}
