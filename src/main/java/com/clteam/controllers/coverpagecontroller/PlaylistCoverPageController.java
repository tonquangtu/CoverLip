package com.clteam.controllers.coverpagecontroller;

import com.clteam.model.Playlist;
import com.clteam.services.commonservice.api.PlayListCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrgnu on 30/04/2017.
 */
@Controller
public class PlaylistCoverPageController {

    @Autowired
    PlayListCoverService playListCoverService;

    @RequestMapping("/playlist")
    public ModelAndView PlaylistCoverPage(){

        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        List<Playlist> playlistList = playListCoverService.getListPlayListCover(-1);
        map.put("playlistList", playlistList);

        modelAndView.setViewName("coverpage/playlist_cover_page");
        modelAndView.addAllObjects(map);

        return modelAndView;
    }
}
