package com.clteam.controllers.commonpagecontroller;

import com.clteam.model.SearchData;
import com.clteam.services.commonservice.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell on 24-May-17.
 */
@Controller
public class SearchController {

    @Autowired
    SearchServiceImpl searchService;

    @RequestMapping(path = "search", method = RequestMethod.GET)
    @ResponseBody
    public SearchData quickSearch(@RequestParam("searchString") String searchString,
                             @RequestParam("limit") String limit,
                             @RequestParam(value = "type", defaultValue = "1") String type) {
        SearchData searchData = null;
        try {
            int searchType = Integer.parseInt(type);
            int searchLimit = Integer.parseInt(limit);
            searchData = searchService.search(searchString, searchType, searchLimit);
        }catch (Exception e) {
            searchData = new SearchData();
        }

        return searchData;
    }

    @RequestMapping(path="search-all", method= RequestMethod.GET)
    public ModelAndView searchAll(@RequestParam("searchString") String searchString,
                                  @RequestParam("limit") String limit,
                                  @RequestParam(value = "type", defaultValue = "1") String type,
                                  @RequestParam(value = "resultType", defaultValue = "1") String resultType) {

        ModelAndView modelAndView = new ModelAndView();
        SearchData searchData;
        Map<String, Object> container = new HashMap<>();
        try {

            int searchType = Integer.parseInt(type);
            int expectedResult = Integer.parseInt(resultType);
            int searchLimit = Integer.parseInt(limit);

            if (expectedResult == SearchServiceImpl.EXPECTED_ALL) {
                searchData = searchService.search(searchString, searchType, searchLimit);

            } else if (expectedResult == SearchServiceImpl.EXPECTED_VIDEO) {
                searchData = searchService.searchVideos(searchString, searchType, searchLimit);

            } else if (expectedResult == SearchServiceImpl.EXPECTED_USER) {
                searchData = searchService.searchUsers(searchString, searchLimit);

            } else {
                searchData = new SearchData();
            }

        }catch(Exception e) {
            searchData = new SearchData();
        }

        container.put("searchData", searchData);
        modelAndView.setViewName("commonpage/search_page");
        return modelAndView;
    }

}
