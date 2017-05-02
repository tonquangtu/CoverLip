package com.clteam.controllers.usercontroller;

import com.clteam.model.OneCardInfo;
import com.clteam.services.userservice.api.NewCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nguyenthanhtung on 29/04/2017.
 */
@Controller
public class HomeCoverPageController {
    @Autowired
    private NewCoverService newCoverService;
    @RequestMapping("/")
    public String visitHomePage(HashMap<String, Object> map){
        List<OneCardInfo> listNewCover = newCoverService.getListNewCover();
        map.put("listNewCover", listNewCover);
        return "topcoverpage/top_cover_page";
    }
}
