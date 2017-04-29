package com.clteam.services.userservice.impl;

import com.clteam.dataobject.*;
import com.clteam.model.OneCardInfo;
import com.clteam.repositories.api.AccountRepository;
import com.clteam.repositories.api.UserRepository;
import com.clteam.repositories.api.VideoRepository;
import com.clteam.services.userservice.api.NewCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyenthanhtung on 25/04/2017.
 */
@Service
public class NewCoverServiceImpl implements NewCoverService {

    @Autowired
    private VideoRepository videoInfoRepository;

    public List<OneCardInfo> getListNewCover() {
        List<OneCardInfo> result = new ArrayList<OneCardInfo>();
        List<NewCover> listNewCover;
        listNewCover = newCoverRepository.getListNewCover();
        System.out.println("Size" + listNewCover.size());
        for(int i=0; i<listNewCover.size(); i++){
            NewCover newCover= listNewCover.get(i);
            int videoId = newCover.getVideoId();
            VideoInfo videoInfo =videoInfoRepository.getVideoInfo(videoId);
            int accountId = videoInfo.getAccountId();
            Account account = accountRepository.getAccount(accountId);
            UserInfo userInfo = userInfoRepository.getUserInfo(accountId);
            CoverInfo coverInfo = coverInfoRepository.getCoverInfo(videoId);
            OneCardInfo oneCardInfo = new OneCardInfo(videoInfo,account,userInfo, coverInfo);
            result.add(oneCardInfo);
        }
        return result;
    }
}
