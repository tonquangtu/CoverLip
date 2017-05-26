package com.clteam.controllers.usercontroller;

import com.clteam.security.util.AccountUtil;
import com.clteam.services.userservice.api.TopIdolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

/**
 * Created by mrgnu on 23/05/2017.
 */
@Controller
public class FollowIdolController {

    @Autowired
    TopIdolService topIdolService;

    @RequestMapping(value = "/follow_idol")
    public @ResponseBody
    int followIdol( @RequestParam String acoundId,
                    @RequestParam String idolId,
                    @RequestParam String statusFollow){

        int acoundIdx = AccountUtil.getCurrentUserId();
        if(acoundIdx>0) {
            int idolIdx = Integer.parseInt(idolId);
            int statusFollowIdx = Integer.parseInt(statusFollow);
            int check = 1;

            if (statusFollowIdx == 0) {
                Timestamp timestampFollow = new Timestamp(System.currentTimeMillis());
                check = topIdolService.setFollowIdol(acoundIdx, idolIdx, timestampFollow);
            } else {
                check = topIdolService.unFollowIdol(acoundIdx, idolIdx);
            }

            return check;
        }else return -1;

    }
}
