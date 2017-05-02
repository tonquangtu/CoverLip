package com.clteam.services.userservice.impl;

import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.NewCoverEntity;
import com.clteam.dataobject.VideoInfoEntity;
import com.clteam.model.Cover;
import com.clteam.repositories.api.CoverRepository;
import com.clteam.services.userservice.api.NewCoverService;
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
            Cover cover = new Cover();
            VideoInfoEntity videoInfoEntity = newCoverEntityList.get(i).getVideoInfoByVideoId();
            Collection<CoverInfoEntity> coverInfoEntities =  videoInfoEntity.getCoverInfosById();
            if(coverInfoEntities!=null){
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity)coverInfoEntities.toArray()[0];
                cover.copyData(coverInfoEntity, videoInfoEntity);
                coverList.add(cover);
            }
        }
        return coverList;
    }
}
