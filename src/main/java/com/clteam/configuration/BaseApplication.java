package com.clteam.configuration;

import com.clteam.services.userservice.api.UserService;
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
    UserService userService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (!isIndexed) {
            isIndexed = true;
            System.out.println("Start Index for all table");
            userService.indexForAllTables();
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
