package com.clteam.controllers;

import com.clteam.model.Account;
import com.clteam.model.Cover;
import com.clteam.model.VideoWrapper;
import com.clteam.services.commonservice.api.VideoService;
import com.clteam.services.commonservice.impl.SearchServiceImpl;
import com.clteam.services.userservice.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dell on 04-May-17.
 */
@Controller
public class TestSearchController {

    @Autowired
    VideoService videoService;

    @Autowired
    UserService userService;

    @Autowired
    SearchServiceImpl searchService;


    @RequestMapping("test/{name}")
    public ModelAndView testSearch(@PathVariable String name) {

     //   videoService.createTestLipSyncData();

        System.out.println("Vao test");
        ModelAndView modelAndView = new ModelAndView();
        List<Cover> covers = videoService.searchCoverByName(name, 4);
        StringBuilder coverNames = new StringBuilder();
        coverNames.append("Input: " + name + "<br>");
        if (covers != null && covers.size() > 0) {
            System.out.println("Tim thay ket qua");

            for (Cover cover : covers) {

                coverNames.append(cover.getCoverName() + "<br>");
            }
        }
        Map<String, String> map = new HashMap<>();
        map.put("coverName", coverNames.toString());
        modelAndView.addAllObjects(map);
        modelAndView.setViewName("test/test");
        return modelAndView;


    }

    @RequestMapping("test-search/{searchString}")
    public ModelAndView testSearchVideo(@PathVariable String searchString) {

        //   videoService.createTestLipSyncData();

        int limit = 6;
        System.out.println("Vao test");
        ModelAndView modelAndView = new ModelAndView();
        List<VideoWrapper> videoWrappers = searchService.searchCovers(searchString, limit);
        StringBuilder coverNames = new StringBuilder();
        coverNames.append("Input: " + searchString + "<br>");
        if (videoWrappers != null && videoWrappers.size() > 0) {
            System.out.println("Tim thay ket qua");

            for (VideoWrapper videoWrapper : videoWrappers) {

                coverNames.append(videoWrapper.getVideoName() +
                        " - " + videoWrapper.getVideo().getAccount().getFullname() +
                        " - " + videoWrapper.getVideo().getId()
                       + "<br>");
            }
        }
        Map<String, String> map = new HashMap<>();
        map.put("coverName", coverNames.toString());
        modelAndView.addAllObjects(map);
        modelAndView.setViewName("test/test");
        return modelAndView;
    }

    @RequestMapping("test-searchA/{searchString}")
    public ModelAndView testSearchAccount(@PathVariable String searchString) {


        int limit = 6;
        System.out.println("Vao test");
        ModelAndView modelAndView = new ModelAndView();
        List<Account> accounts = searchService.searchUsers(searchString, limit);
        StringBuilder coverNames = new StringBuilder();
        coverNames.append("Input: " + searchString + "<br>");
        if (accounts != null && accounts.size() > 0) {
            System.out.println("Tim thay ket qua");

            for (Account account : accounts) {

                coverNames.append(account.getFullname() + "-" + account.getId()
                        + "<br>");
            }
        }
        Map<String, String> map = new HashMap<>();
        map.put("coverName", coverNames.toString());
        modelAndView.addAllObjects(map);
        modelAndView.setViewName("test/test");
        return modelAndView;
    }




}
