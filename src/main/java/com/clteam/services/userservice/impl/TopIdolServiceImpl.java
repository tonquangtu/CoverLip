package com.clteam.services.userservice.impl;

import com.clteam.dataobject.TopCoverIdolEntity;
import com.clteam.dataobject.UserInfoEntity;
import com.clteam.model.TopIdol;
import com.clteam.repositories.api.TopRepository;
import com.clteam.services.userservice.api.TopIdolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mrgnu on 30/04/2017.
 */
@Service
public class TopIdolServiceImpl implements TopIdolService {

    @Autowired
    private TopRepository topRepository;

    public List<TopIdol> getListTopCoverIdols(int limit) {

        List<TopIdol> topIdolList = new ArrayList<TopIdol>();
        List<TopCoverIdolEntity> topCoverIdols = topRepository.getListTopCoverIdols(limit);

        for (int i=0; i < topCoverIdols.size(); i++){

            TopIdol topIdol = new TopIdol();
            TopCoverIdolEntity topCoverIdolEntity = topCoverIdols.get(i);
            Collection<UserInfoEntity> userInfoEntities = topCoverIdolEntity.getAccountByAccountId().getUserInfosById();

            if (userInfoEntities != null){

                UserInfoEntity userInfoEntity = (UserInfoEntity) userInfoEntities.toArray()[0];
                topIdol.copyData(topCoverIdolEntity, userInfoEntity, userInfoEntity.getAccountByAccountId());
            }

            topIdolList.add(topIdol);

        }

        return topIdolList;
    }
}
