package com.clteam.controllers.usercontroller;

import com.clteam.model.OneCardInfo;
import com.clteam.services.userservice.api.NewCoverService;
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
public class HomeCoverController {
    @Autowired
    private NewCoverService newCoverService;
    @RequestMapping("/")
    public ModelAndView getHomePage(){
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();
        List<OneCardInfo> listOneCardInfo = newCoverService.getListNewCover();
        map.put("listNewCover", listOneCardInfo);
        modelAndView.setViewName("homecoverpage/home_cover_page");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
