package com.clteam.configuration;

import com.clteam.services.commonservice.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Dell on 04-May-17.
 */
@Component
public class BaseApplication implements ApplicationListener<ContextRefreshedEvent> {

    public static boolean isIndexed = false;

    @Autowired
    SearchServiceImpl searchService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (!isIndexed) {
            isIndexed = true;
            System.out.println("Start Index for all table");
            searchService.indexSearchTables();
            System.out.println("Complete index for all table");

//            List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.upload");
//
//            try {
//                Credential credential = Auth.authorize(scopes, "uploadvideo");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}
