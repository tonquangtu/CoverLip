package com.clteam.services.commonservice.impl;

import com.clteam.model.*;
import com.clteam.repositories.api.CoverRepository;
import com.clteam.repositories.api.UserRepository;
import com.clteam.services.commonservice.api.RecommenderService;
import com.clteam.services.commonservice.api.VideoService;
import com.clteam.utils.SimilarityVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Dell on 09-May-17.
 */
@Service
public class RecommenderServiceImpl implements RecommenderService{

    @Autowired
    UserRepository userRepo;

    @Autowired
    CoverRepository coverRepo;

    @Autowired
    VideoService videoService;

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
    public List<Cover> recommendCovers(Cover currCover, User user, int limit) {

        List<Cover> recommendationList = new ArrayList<>();
        if (limit <= 0) {
            return recommendationList;
        }

        else if (currCover == null && user == null ) {
            recommendationList = videoService.getHotCovers(limit);

        } else if (user == null) {

            System.out.println("Input : " + currCover.getCoverName());

            int limitItemInClassify = 10;
            Map<String, List<CoverWrapper>> container = new HashMap<>();


            List<Cover> coversSameName = videoService.searchCoverByName(currCover.getCoverName(), limitItemInClassify);
            List<Cover> coversSameOwner = videoService.findTopCoverOfAccount(currCover.getVideo().getAccount().getId(), limitItemInClassify);
            List<Playlist> playlists = videoService.findCoversSamePlaylist(currCover.getVideo().getId(), limitItemInClassify);
            List<Cover> hotCovers = videoService.getHotCovers(limitItemInClassify);

            System.out.println(coversSameName.size() + "," + coversSameOwner.size() + "," + hotCovers.size());
            container.put(RecommendationData.NAME_CLASS, transformToWrapperList(currCover,coversSameName, RecommendationData.NAME_CLASS));
            container.put(RecommendationData.OWNER_CLASS, transformToWrapperList(currCover,coversSameOwner, RecommendationData.OWNER_CLASS));
            container.put(RecommendationData.HOT_CLASS, transformToWrapperList(currCover, hotCovers, RecommendationData.HOT_CLASS));

            List<CoverWrapper> playlistWrappers = new ArrayList<>();
            if (playlists != null && playlists.size() > 0) {

                for (Playlist playlist : playlists) {

                    List<Cover> coversInPlaylist = playlist.getCoverInPlaylist();
                    playlistWrappers.addAll(transformToWrapperList(currCover, coversInPlaylist, RecommendationData.PLAYLIST_CLASS));
                }
            }
            container.put(RecommendationData.PLAYLIST_CLASS, playlistWrappers);
            CoverWrapper currCoverWrapper = videoService.getCoverWrapper(currCover);

            recommendationList = filterRecommendationCover( currCoverWrapper, container, limit);
        }

        return recommendationList;
    }

    @Override
    public List<LipSync> recommendLipSyncs(LipSync currLipSync, User user, int limit) {

        List<LipSync> recommendationList = new ArrayList<>();
        if (limit <= 0) {
            return recommendationList;
        }

        else if (currLipSync == null && user == null ) {
            recommendationList = videoService.getHotLipSyncs(limit);

        } else if (user == null) {

            int limitItemInClassify = 10;
            Map<String, List<LipSyncWrapper>> container = new HashMap<>();

            List<LipSync> lipSyncsSameName = videoService.searchLipSyncByName(currLipSync.getLipSyncTemplate().getLipSyncTemplateName(), limitItemInClassify);
            printLipSync("Same LipSync Name", lipSyncsSameName);

            recommendationList = lipSyncsSameName;

        }

        return recommendationList;
    }

    private List<Cover> filterRecommendationCover(CoverWrapper currCoverWrapper, Map<String, List<CoverWrapper>> container, int limit) {

        int numClass = container.size();
        List<Cover> filterCovers = new ArrayList<>();
        List<CoverWrapper> filterWrapperList = new ArrayList<>();
        List<CoverWrapper> subFilterList;
        int classLimit = 10;
        subFilterList = filterClass(currCoverWrapper,container.get(RecommendationData.NAME_CLASS), SimilarityVideo.FILTER_BY_NAME_CLASS, classLimit);
        filterWrapperList.addAll(subFilterList);

        subFilterList = filterClass(currCoverWrapper, container.get(RecommendationData.OWNER_CLASS), SimilarityVideo.FILTER_BY_OWNER_CLASS, classLimit);
        filterWrapperList.addAll(subFilterList);

        subFilterList = filterClass(currCoverWrapper, container.get(RecommendationData.HOT_CLASS), SimilarityVideo.FILTER_BY_HOT_CLASS, classLimit);
        filterWrapperList.addAll(subFilterList);

        subFilterList = filterClass(currCoverWrapper, container.get(RecommendationData.PLAYLIST_CLASS), SimilarityVideo.FILTER_BY_PLAYLIST_CLASS, classLimit);
        filterWrapperList.addAll(subFilterList);

        Collections.sort(filterWrapperList);

        int numItemInClass = (limit * 2) / numClass;
        int countItemNameClass = 0;
        int countItemOwnerClass = 0;
        int countItemHotClass = 0;
        int countItemPlaylistClass = 0;

        int length = filterWrapperList.size();
        for (int i = 0;  i < length; i++) {

            Cover nextItem = filterWrapperList.get(i).getCover();
            if (!Cover.isExitsItem(nextItem, filterCovers)) {

                String recommendationClass = filterWrapperList.get(i).getRecommendationClass();
                if (recommendationClass.equals(RecommendationData.NAME_CLASS) && countItemNameClass < numItemInClass) {
                    filterCovers.add(nextItem);
                    countItemNameClass ++;
                } else if (recommendationClass.equals(RecommendationData.OWNER_CLASS) && countItemOwnerClass < numItemInClass) {
                    filterCovers.add(nextItem);
                    countItemOwnerClass ++;
                } else if (recommendationClass.equals(RecommendationData.HOT_CLASS) && countItemHotClass < numItemInClass) {
                    filterCovers.add(nextItem);
                    countItemHotClass ++;
                } else if (recommendationClass.equals(RecommendationData.PLAYLIST_CLASS) && countItemPlaylistClass < numItemInClass) {
                    filterCovers.add(nextItem);
                    countItemPlaylistClass ++;
                }
            }
        }

        System.out.println("CountName: " + countItemNameClass);
        System.out.println("CountOwner: " + countItemOwnerClass);
        System.out.println("CountHot: " + countItemHotClass);
        System.out.println("CountPlaylist: " + countItemPlaylistClass);

        return (filterCovers.size() > limit ? filterCovers.subList(0, limit) : filterCovers);
    }

    public List<CoverWrapper> filterClass(CoverWrapper currCoverWrapper, List<CoverWrapper> items, int state, int limit) {

        for (CoverWrapper item : items) {

            float similarity = SimilarityVideo.calculateSimilarity(currCoverWrapper, item, state);
            item.setSimilarity(similarity);
        }

        Collections.sort(items);
        List<CoverWrapper> filterWrapperList = new ArrayList<>();
        int length = items.size();
        for (int i = 0; i < limit && i < length; i++) {

            filterWrapperList.add(items.get(i));
        }

        return filterWrapperList;
    }

    private List<CoverWrapper> transformToWrapperList(Cover currCover, List<Cover> covers, String recommendationClass) {

        List<CoverWrapper> coverWrappers = new ArrayList<>();

        if (currCover != null && covers != null && covers.size() > 0) {

            for (Cover cover : covers) {

                if (!currCover.equals(cover)) {
                    CoverWrapper coverWrapper = videoService.getCoverWrapper(cover);
                    if (coverWrapper != null) {
                        coverWrapper.setRecommendationClass(recommendationClass);
                        coverWrappers.add(coverWrapper);
                    }
                }
            }
        }
        return coverWrappers;
    }

    public void printConsole(String tag, List<CoverWrapper> covers) {

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(tag);
        if (covers != null) {

            System.out.println("Size: " + covers.size());
            for (CoverWrapper cover : covers) {

                System.out.println("Cover : " + cover.getCover().getCoverName());
                System.out.println("Video id: " + cover.getCover().getVideo().getId());
                System.out.println("accountId:" + cover.getCover().getVideo().getAccount().getId());
                String playlistIds = "";
                for (Integer s : cover.getPlaylistId()) {
                    playlistIds += s + ", ";
                }
                System.out.println("PlaylistId: " + playlistIds);
                System.out.println("IsHot:" + cover.isHot());
                System.out.println("User: numItem: " + (cover.getUser().getNumPlaylist() + cover.getUser().getNumLipsync() + cover.getUser().getNumCover()));
                System.out.println("User: numFollow: " + cover.getUser().getNumHaveFollowed());
                System.out.println("numView:" + cover.getCover().getVideo().getNumView());
                System.out.println("NumLike: " + cover.getCover().getVideo().getNumLike());
                System.out.println("NumComment: " + cover.getCover().getVideo().getNumComment());
                System.out.println("Description: " + cover.getCover().getVideo().getDescription());
                System.out.println("---------------------------------------------------------------------------------------------------------");
            }
        }
    }

    public void printLipSync(String tag, List<LipSync> lipSyncs) {

        if (lipSyncs == null) {
            System.out.println(tag + ": Null");
        } else {

            for (LipSync lipSync : lipSyncs)  {
                System.out.println("VideoId: " + lipSync.getVideo().getId());
                System.out.println("LipSync Name: " + lipSync.getLipSyncTemplate().getLipSyncTemplateName());
                System.out.println("LipSync owner: " + lipSync.getVideo().getAccount().getUsername());
                System.out.println("LipSync template id:" + lipSync.getLipSyncTemplate().getId());

            }



        }

    }

}
