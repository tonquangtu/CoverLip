package com.clteam.services.commonservice.impl;

import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.NewCoverEntity;
import com.clteam.dataobject.VideoInfoEntity;
import com.clteam.model.Cover;
import com.clteam.model.Video;
import com.clteam.repositories.api.CoverRepository;
import com.clteam.services.commonservice.api.NewCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by nguyenthanhtung on 25/04/2017.
 */
@Service
public class NewCoverServiceImpl implements NewCoverService {

    @Autowired
    private CoverRepository coverRepository;

    public List<Cover> getListNewCover(int limit) {
        List<NewCoverEntity> newCoverEntityList = coverRepository.getListNewCover(limit);
        List<Cover> coverList = new ArrayList<Cover>();
        for(int i=0; i<newCoverEntityList.size(); i++){
//            Cover cover = new Cover();
            VideoInfoEntity videoInfoEntity = newCoverEntityList.get(i).getVideoInfoByVideoId();
            Collection<CoverInfoEntity> coverInfoEntities =  videoInfoEntity.getCoverInfosById();
            if(coverInfoEntities!=null){
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity)coverInfoEntities.toArray()[0];
                Video video = new Video();
                video.copyData(videoInfoEntity, videoInfoEntity.getAccountByAccountId());
                Cover cover = new Cover(video, coverInfoEntity.getCoverName(), coverInfoEntity.getMp3Link());
//                cover.copyData(coverInfoEntity, videoInfoEntity, videoInfoEntity.getAccountByAccountId());
                coverList.add(cover);
            }
        }
        return coverList;
    }
}
