package com.clteam.controllers.usercontroller;

import com.clteam.model.Account;
import com.clteam.model.Cover;
import com.clteam.model.User;
import com.clteam.services.commonservice.api.VideoService;
import com.clteam.services.userservice.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Dell on 28-Apr-17.
 */

@Controller
public class VideoPlayerPageController {

    @Autowired
    VideoService videoService;

    @Autowired
    UserService userService;


    @RequestMapping("cover/{singerName}/{songName}/{videoIdString}")
    public ModelAndView visitVideoPlayerPage(@PathVariable String singerName,
                                             @PathVariable String songName,
                                             @PathVariable String videoIdString) {

        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int videoId = Integer.parseInt(videoIdString);
            Cover cover = videoService.getCoverInfo(videoId);

            if (cover != null) {

                map.put("cover", cover);
                Account ownerAccount = cover.getVideo().getAccount();

                if (ownerAccount != null) {
                    User user = userService.getUser(ownerAccount.getId());
                    map.put("user", user);
                }
                modelAndView.setViewName("videoplayerpage/video_player_page");
            }else {
                modelAndView.setViewName("common/error");
            }
        }catch(Exception e) {
            modelAndView.setViewName("common/error");
            e.printStackTrace();
        }

        modelAndView.addAllObjects(map);
        return modelAndView;
    }


}
