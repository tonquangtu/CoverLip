package com.clteam.services.userservice.impl;

import com.clteam.dataobject.TopCoverIdolEntity;
import com.clteam.dataobject.TopLipSyncIdolEntity;
import com.clteam.dataobject.TopListEntity;
import com.clteam.dataobject.UserInfoEntity;
import com.clteam.model.TopIdol;
import com.clteam.repositories.api.TopRepository;
import com.clteam.services.userservice.api.TopIdolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
        List<TopCoverIdolEntity> topCoverIdols = new ArrayList<TopCoverIdolEntity>();

        int maxTopId = topRepository.getMaxTopId();
        while (topCoverIdols.size() == 0 && maxTopId >= 0) {
            topCoverIdols = topRepository.getListTopCoverIdols(limit, maxTopId);
            maxTopId--;
        }

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

    @Override
    public List<TopIdol> getListTopLipSyncIdols(int limit) {

        List<TopIdol> topIdolList = new ArrayList<TopIdol>();
        List<TopLipSyncIdolEntity> topLipSyncIdols = new ArrayList<TopLipSyncIdolEntity>();

        int maxTopId = topRepository.getMaxTopId();
        while (topLipSyncIdols.size() == 0 && maxTopId >= 0) {
            topLipSyncIdols = topRepository.getListTopLipSyncIdols(limit, maxTopId);
            maxTopId--;
        }

        for (int i=0; i < topLipSyncIdols.size(); i++){
            TopIdol topIdol = new TopIdol();
            TopLipSyncIdolEntity topLipSyncIdolEntity = topLipSyncIdols.get(i);
            Collection<UserInfoEntity> userInfoEntities = topLipSyncIdolEntity.getAccountByAccountId().getUserInfosById();

            if (userInfoEntities != null){
                UserInfoEntity userInfoEntity = (UserInfoEntity) userInfoEntities.toArray()[0];
                topIdol.copyData(topLipSyncIdolEntity, userInfoEntity, userInfoEntity.getAccountByAccountId());
            }

            topIdolList.add(topIdol);
        }
        return topIdolList;
    }

    @Override
    public int setFollowIdol(int acoundId, int topId, Timestamp timestampFollow) {

        int check = topRepository.setFollowIdol(acoundId, topId, timestampFollow);
        return check;
    }

    @Override
    public int unFollowIdol(int acoundId, int topId) {
        int check = topRepository.unFollowIdol(acoundId, topId);
        return check;
    }

    @Override
    public int checkFollowIdol(int acoundId, int acoundFollowId) {
        int check = topRepository.checkFollowIdol(acoundId, acoundFollowId);
        return check;
    }


}
