package com.clteam.services.userservice.impl;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.IdolFollowingEntity;
import com.clteam.dataobject.TopLipSyncIdolEntity;
import com.clteam.dataobject.UserInfoEntity;
import com.clteam.model.*;
import com.clteam.repositories.api.UserRepository;
import com.clteam.services.userservice.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.clteam.model.FollowingList.FAN_TYPE;
import static com.clteam.model.FollowingList.IDOL_TYPE;

/**
 * Created by Dell on 01-May-17.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepo;

    public void indexForAllTables() {

        userRepo.indexTables();
    }

    public User getUser(int accountId) {

        User user = null;
        UserInfoEntity userEntity = userRepo.getUserInfoByAccountId(accountId);

        if (userEntity != null) {
            user = new User();
            user.copyData(userEntity);
            AccountEntity accountEntity = userEntity.getAccountByAccountId();
            Account account = new Account();
            if (accountEntity != null) {
                account.copyData(accountEntity);
            }
            user.setAccount(account);
        }
        return user;
    }

    @Override
    public List<TopIdol> getLipSyncIdols(int limit) {

        List<TopIdol> idols = new ArrayList<>();
        List<TopLipSyncIdolEntity> topLipSyncIdolEntities = userRepo.getTopLipSyncIdols(limit);
        if (topLipSyncIdolEntities != null) {
            for (TopLipSyncIdolEntity idolEntity : topLipSyncIdolEntities) {

                TopIdol idol = new TopIdol();
                AccountEntity accountEntity = idolEntity.getAccountByAccountId();
                UserInfoEntity userEntity = userRepo.getUserInfoByAccountId(idolEntity.getAccountId());
                if (accountEntity != null && userEntity != null) {
                    idol.copyData(idolEntity, userEntity, accountEntity);
                }
                idols.add(idol);
            }
        }

        return idols;
    }

    public FollowingList getIdolOfUser(int accountId, int limit, int currentIdolAccountId) {
        List<IdolFollowingEntity> idolFollowingEntities = userRepo.getListIdolOfUser(accountId, limit, currentIdolAccountId);
        if (idolFollowingEntities == null) {
            return null;
        }
        List<Following> followings = new ArrayList<>();
        for (IdolFollowingEntity idolFollowingEntity : idolFollowingEntities) {
            AccountEntity accountEntity = idolFollowingEntity.getAccountByFollowedAccountId();
            Account account = new Account();
            account.copyData(accountEntity);
            Following following = new Following(account, idolFollowingEntity.getTimeStartFollow());
            followings.add(following);
        }

        return new FollowingList(IDOL_TYPE, followings);
    }

    public FollowingList getFanOfUser(int accountId, int limit, int currentIdolFollowingId) {
        List<IdolFollowingEntity> idolFollowingEntities = userRepo.getListFanOfUser(accountId, limit, currentIdolFollowingId);
        if (idolFollowingEntities == null) {
            return null;
        }
        List<Following> followings = new ArrayList<>();
        for (IdolFollowingEntity idolFollowingEntity : idolFollowingEntities) {
            AccountEntity accountEntity = idolFollowingEntity.getAccountByAccountId();
            Account account = new Account();
            account.copyData(accountEntity);
            Following following = new Following(account,idolFollowingEntity.getTimeStartFollow());
            followings.add(following);
        }

        return new FollowingList(FAN_TYPE, followings);
    }
}
