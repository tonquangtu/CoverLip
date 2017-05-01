package com.clteam.services.userservice.impl;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.VideoInfoEntity;
import com.clteam.model.Cover;
import com.clteam.model.Video;
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

    public Cover getCoverInfo(int coverId) {

        Cover cover = null;
        VideoInfoEntity videoEntity = videoRepo.getVideoInfo(coverId);
        if (videoEntity != null) {

            Collection<CoverInfoEntity> coverEntities = videoEntity.getCoverInfosById();
            if (coverEntities != null && coverEntities.size() >= 1) {
                CoverInfoEntity coverEntity = (CoverInfoEntity)coverEntities.toArray()[0];
                if (coverEntity != null) {

                    cover = new Cover();
                    cover.setCoverName(coverEntity.getCoverName());
                    cover.setMp3Link(coverEntity.getMp3Link());

                    Video video = new Video();
                    AccountEntity accountEntity = videoEntity.getAccountByAccountId();
                    video.copyData(videoEntity, accountEntity);
                    cover.setVideo(video);
                }
            }
        }
        return cover;
    }
}
