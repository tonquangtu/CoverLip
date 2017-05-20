package com.clteam.services.commonservice.impl;

import com.clteam.dataobject.HotLipSyncEntity;
import com.clteam.dataobject.LipSyncInfoEntity;
import com.clteam.dataobject.LipSyncTemplateInfoEntity;
import com.clteam.dataobject.VideoInfoEntity;
import com.clteam.model.LipSync;
import com.clteam.model.LipSyncTemplate;
import com.clteam.model.Video;
import com.clteam.repositories.api.LipSyncRepository;
import com.clteam.services.commonservice.api.LipSyncService;
import com.clteam.services.commonservice.api.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 21-May-17.
 */
@Service
public class LipSyncServiceImpl implements LipSyncService{

    @Autowired
    LipSyncRepository lipSyncRepo;

    @Autowired
    VideoService videoService;


    @Override
    public LipSync getLipSync(int videoId) {

        LipSyncInfoEntity lipSyncEntity = lipSyncRepo.getLipSync(videoId);
        return getLipSync(lipSyncEntity);
    }


    @Override
    public List<LipSync> getHotLipSyncs(int limit) {

        List<LipSync> hotLipSyncs = new ArrayList<>();
        List<HotLipSyncEntity> hotLipSyncEntities = lipSyncRepo.getLimitHotLipSync(limit);
        if (hotLipSyncEntities != null && hotLipSyncEntities.size() > 0) {

            for(HotLipSyncEntity hotLipSyncEntity : hotLipSyncEntities) {

                LipSync lipSync = getLipSync(hotLipSyncEntity.getVideoId());
                if (lipSync != null) {
                    hotLipSyncs.add(lipSync);
                }
            }
        }
        return hotLipSyncs;
    }

    @Override
    public List<LipSync> getHotLipSyncsFrom(int start, int limit) {





        return null;
    }


    @Override
    public LipSync getLipSync(LipSyncInfoEntity lipSyncEntity) {

        LipSync lipSync = null;
        if (lipSyncEntity != null) {
            lipSync = new LipSync();
            LipSyncTemplateInfoEntity templateEntity = lipSyncEntity.getLipSyncTemplateInfoByLipSyncTemplateId();
            if (templateEntity != null) {

                LipSyncTemplate template = new LipSyncTemplate();
                VideoInfoEntity templateVideoEntity = templateEntity.getVideoInfoByVideoId();
                if (templateVideoEntity != null) {
                    Video video = videoService.getVideo(templateVideoEntity);
                    template.setVideo(video);
                }
                template.copyData(templateEntity);
                lipSync.setLipSyncTemplate(template);
            }

            VideoInfoEntity videoEntity = lipSyncEntity.getVideoInfoByVideoId();
            if (videoEntity != null) {
                Video lipSyncVideo = videoService.getVideo(videoEntity);
                lipSync.setVideo(lipSyncVideo);
            }
        }
        return lipSync;
    }


}
