package com.clteam.services.userservice.impl;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.UserInfoEntity;
import com.clteam.model.Account;
import com.clteam.model.Cover;
import com.clteam.model.Playlist;
import com.clteam.model.User;
import com.clteam.repositories.api.CoverRepository;
import com.clteam.repositories.api.UserRepository;
import com.clteam.services.commonservice.api.VideoService;
import com.clteam.services.userservice.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 01-May-17.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepo;

    @Autowired
    CoverRepository coverRepo;

    @Autowired
    VideoService videoService;

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

    /**
     Thuc hien goi y dua tren 8 tieu chi.
     Phan lop cac bai hat lien quan den bai hat hien tai --> Moi tieu chi se co 1 lop
     Sau khi phan thanh 8 lop, moi lop se lay 10 bai hat --> Chay ham f(x, y) tren tap du lieu do
     Xay dung ham f(x, y) de danh gia y voi x la bai hat hien tai
     Ham F(x, y) se cho ra 1 so diem tu 1 --> 100
     8 tieu chi:
     Ten bai hat
     Ten nguoi cover
     Cung playlist
     Muc do thinh hanh: Hot, bang xep hang + Do noi tieng cua ca sy
     Mo ta  ve bai hat do
     Thoi gian dang
     So luot like + so luot view
     */
    @Override
    public List<Cover> recommendationCoverList(Cover forCover, User user, int limit) {

        List<Cover> recommendationList = new ArrayList<>();
        if (forCover == null && user == null) {
            recommendationList = videoService.getHotCovers(limit);

        } else if (user == null) {

            int limitItemInClassify = 10;
            List<Cover> coversSameName = videoService.searchCoverByName(forCover.getCoverName(), limitItemInClassify);
            List<Cover> coversSameOwner = videoService.getCoversByAccountId(forCover.getVideo().getAccount().getId(), limitItemInClassify);
            List<Playlist> playlists = videoService.findCoversSamePlaylist(forCover.getVideo().getId(), limitItemInClassify);


        }

        return recommendationList;

    }




}
