package com.clteam.controllers.commonpagecontroller;

import com.clteam.model.SearchData;
import com.clteam.services.commonservice.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Dell on 24-May-17.
 */
@Controller
public class SearchController {

    @Autowired
    SearchServiceImpl searchService;

    @RequestMapping(path = "search", method = RequestMethod.GET)
    @ResponseBody
    public SearchData search(@RequestParam("searchString") String searchString, @RequestParam("limit") String limit) {
        SearchData searchData = null;
        try {

            int searchLimit = Integer.parseInt(limit);
            searchData = searchService.search(searchString, searchLimit);
        }catch (Exception e) {
            searchData = new SearchData();
        }

        return searchData;
    }

}
