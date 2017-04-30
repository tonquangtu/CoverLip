package com.clteam.services.userservice.impl;

import com.clteam.model.FullCoverInfo;
import com.clteam.repositories.api.VideoRepository;
import com.clteam.services.userservice.api.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Dell on 28-Apr-17.
 */
@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoRepository videoRepo;

    public FullCoverInfo getFullCoverInfo(long coverId) {

        FullCoverInfo fullCoverInfo = null;

        VideoInfo videoInfo = videoRepo.getVideoInfo(coverId);
        if (videoInfo != null) {

            Collection<CoverInfo> covers = videoInfo.getCoverInfosById();
            if (covers != null && covers.size() >= 1) {
                CoverInfo cover = (CoverInfo)covers.toArray()[0];
                if (cover != null) {
                    fullCoverInfo = new FullCoverInfo();
                    fullCoverInfo.copyData(cover, videoInfo);
                }
            }
        }

        return fullCoverInfo;
    }
}
