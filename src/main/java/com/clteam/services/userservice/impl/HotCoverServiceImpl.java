package com.clteam.services.userservice.impl;

import com.clteam.dataobject.*;
import com.clteam.model.Cover;
import com.clteam.repositories.api.CoverRepository;
import com.clteam.services.userservice.api.HotCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mrgnu on 29/04/2017.
 */

@Service
public class HotCoverServiceImpl implements HotCoverService{

    @Autowired
    private CoverRepository coverRepository;

    public List<Cover> getListHotCover(int limit) {
        List<Cover> coverList = new ArrayList<Cover>();
        List<HotCoverEntity> hotCoverList = coverRepository.getLimitHotCover(limit);

        for (int i=0; i<hotCoverList.size(); i++){

            Cover cover = new Cover();
            VideoInfoEntity videoInfoEntity = hotCoverList.get(i).getVideoInfoByVideoId();
            Collection<CoverInfoEntity> coverInfoEntities = videoInfoEntity.getCoverInfosById();

            if (coverInfoEntities != null){

                CoverInfoEntity coverInfoEntity = (CoverInfoEntity) coverInfoEntities.toArray()[0];
                cover.copyData(coverInfoEntity, videoInfoEntity, videoInfoEntity.getAccountByAccountId());
                coverList.add(cover);
            }

        }

        return coverList;
    }
}
