package com.clteam.services.userservice.impl;

import com.clteam.dataobject.*;
import com.clteam.model.OneCardInfo;
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
    private VideoRepository videoRepository;

    public List<OneCardInfo> getListNewCover() {
        List<OneCardInfo>listOneCardInfo = new ArrayList<OneCardInfo>();
        List<NewCover> listNewCover = videoRepository.getAllNewCover();
        for (int i=0; i<listNewCover.size(); i++){
            VideoInfo videoInfo = listNewCover.get(i).getVideoInfoByVideoId();
            Account account = videoInfo.getAccountByAccountId();
            UserInfo userInfo = (UserInfo)account.getUserInfosById().toArray()[0];
            CoverInfo coverInfo = (CoverInfo)videoInfo.getCoverInfosById().toArray()[0];
            OneCardInfo oneCardInfo = new OneCardInfo(videoInfo, account, userInfo,coverInfo);
            listOneCardInfo.add(oneCardInfo);
        }
        return listOneCardInfo;
    }
}
