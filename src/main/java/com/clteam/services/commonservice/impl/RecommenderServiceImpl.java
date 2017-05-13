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
            container.put(RecommendationData.COVER_NAME_CLASS,
                    transformToCoverWrapperList(currCover,coversSameName, RecommendationData.COVER_NAME_CLASS));

            container.put(RecommendationData.COVER_OWNER_CLASS,
                    transformToCoverWrapperList(currCover,coversSameOwner, RecommendationData.COVER_OWNER_CLASS));

            container.put(RecommendationData.COVER_HOT_CLASS,
                    transformToCoverWrapperList(currCover, hotCovers, RecommendationData.COVER_HOT_CLASS));

            List<CoverWrapper> playlistWrappers = new ArrayList<>();
            if (playlists != null && playlists.size() > 0) {

                for (Playlist playlist : playlists) {

                    List<Cover> coversInPlaylist = playlist.getCoverInPlaylist();
                    playlistWrappers.addAll(transformToCoverWrapperList(currCover, coversInPlaylist,
                            RecommendationData.COVER_PLAYLIST_CLASS));
                }
            }
            container.put(RecommendationData.COVER_PLAYLIST_CLASS, playlistWrappers);
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

        } else if (currLipSync == null && user == null ) {
            recommendationList = videoService.getHotLipSyncs(limit);

        } else if (user == null) {

            int limitItemInClassify = 10;
            Map<String, List<LipSyncWrapper>> container = new HashMap<>();

            List<LipSync> lipSyncsSameName = videoService.searchLipSyncByName(currLipSync.getLipSyncTemplate().getLipSyncTemplateName(),
                    limitItemInClassify);
            List<LipSync> lipSyncsSameOwner = videoService.findTopLipSyncOfAccount(currLipSync.getVideo().getAccount().getId(),
                    limitItemInClassify);
            List<LipSync> hotLipSyncs = videoService.getHotLipSyncs(limitItemInClassify);

            container.put(RecommendationData.LIP_SYNC_NAME_CLASS,
                    transformToLipSyncWrapperList(currLipSync, lipSyncsSameName, RecommendationData.LIP_SYNC_NAME_CLASS));
            container.put(RecommendationData.LIP_SYNC_OWNER_CLASS,
                    transformToLipSyncWrapperList(currLipSync, lipSyncsSameOwner, RecommendationData.LIP_SYNC_OWNER_CLASS));
            container.put(RecommendationData.LIP_SYNC_HOT_CLASS,
                    transformToLipSyncWrapperList(currLipSync, hotLipSyncs, RecommendationData.LIP_SYNC_HOT_CLASS));

            LipSyncWrapper currLipSyncWrapper = videoService.getLipSyncWrapper(currLipSync);

            recommendationList = filterRecommendationLipSync(currLipSyncWrapper, container, limit);
        }

        return recommendationList;
    }

    private List<Cover> filterRecommendationCover(CoverWrapper currCoverWrapper, Map<String, List<CoverWrapper>> container, int limit) {

        int numClass = container.size();
        List<Cover> filterCovers = new ArrayList<>();
        List<CoverWrapper> filterWrapperList = new ArrayList<>();
        int numItemInClass = (limit * 2) / numClass;
        int classLimit = 7;

        List<CoverWrapper> nameClassFilterList = filterCoverClasses(currCoverWrapper,container.get(RecommendationData.COVER_NAME_CLASS),
                SimilarityVideo.FILTER_BY_COVER_NAME_CLASS, classLimit);
        addRandomCovers(nameClassFilterList, filterWrapperList, numItemInClass);

        List<CoverWrapper> ownerClassFilterList = filterCoverClasses(currCoverWrapper, container.get(RecommendationData.COVER_OWNER_CLASS),
                SimilarityVideo.FILTER_BY_COVER_OWNER_CLASS, classLimit);
        addRandomCovers(ownerClassFilterList, filterWrapperList, numItemInClass);

        List<CoverWrapper> playlistClassFilterList = filterCoverClasses(currCoverWrapper, container.get(RecommendationData.COVER_PLAYLIST_CLASS),
                SimilarityVideo.FILTER_BY_COVER_PLAYLIST_CLASS, classLimit);
        addRandomCovers(playlistClassFilterList, filterWrapperList, numItemInClass);

        List<CoverWrapper> hotClassFilterList = filterCoverClasses(currCoverWrapper, container.get(RecommendationData.COVER_HOT_CLASS),
                SimilarityVideo.FILTER_BY_COVER_HOT_CLASS, classLimit);
        addRandomCovers(hotClassFilterList, filterWrapperList, numItemInClass);

        Collections.sort(filterWrapperList);

        for (CoverWrapper itemWrapper : filterWrapperList) {
            if (itemWrapper.getCover() != null) {
                filterCovers.add(itemWrapper.getCover());
            }
        }

//        return (filterCovers.size() > limit ? filterCovers.subList(0, limit) : filterCovers);
        return filterCovers;
    }

    private List<LipSync> filterRecommendationLipSync(LipSyncWrapper currLipSyncWrapper, Map<String, List<LipSyncWrapper>> container, int limit) {

        int numClass = container.size();
        List<LipSync> filterLipSyncs = new ArrayList<>();
        List<LipSyncWrapper> filterWrapperList = new ArrayList<>();
        int classLimit = 7;
        int numItemInClass = (limit * 2) / numClass;

        List<LipSyncWrapper> nameClassFilter = filterLipSyncClasses(currLipSyncWrapper, container.get(RecommendationData.LIP_SYNC_NAME_CLASS),
                SimilarityVideo.FILTER_BY_LIP_SYNC_NAME_CLASS, classLimit);

        addRandomLipSyncs(nameClassFilter, filterWrapperList, numItemInClass);

        List<LipSyncWrapper> ownerClassFilter = filterLipSyncClasses(currLipSyncWrapper, container.get(RecommendationData.LIP_SYNC_OWNER_CLASS),
                SimilarityVideo.FILTER_BY_LIP_SYNC_OWNER_CLASS, classLimit);

        addRandomLipSyncs(ownerClassFilter, filterWrapperList, numItemInClass);

        List<LipSyncWrapper> hotClassFilter = filterLipSyncClasses(currLipSyncWrapper, container.get(RecommendationData.LIP_SYNC_HOT_CLASS),
                SimilarityVideo.FILTER_BY_LIP_SYNC_HOT_CLASS, classLimit);

        addRandomLipSyncs(hotClassFilter, filterWrapperList, numItemInClass);

        Collections.sort(filterWrapperList);

        for (LipSyncWrapper itemWrapper : filterWrapperList) {
            if (itemWrapper.getLipSync() != null) {
                filterLipSyncs.add(itemWrapper.getLipSync());
            }
        }

//        return (filterLipSyncs.size() > limit ? filterLipSyncs.subList(0, limit) : filterLipSyncs);
        return filterLipSyncs;

    }


    public List<CoverWrapper> filterCoverClasses(CoverWrapper currCoverWrapper, List<CoverWrapper> items, int state, int limit) {

        for (CoverWrapper item : items) {

            float similarity = SimilarityVideo.calculateSimilarityWithCover(currCoverWrapper, item, state);
            item.setSimilarity(similarity);
        }

        Collections.sort(items);

        return (items.size() > limit ? items.subList(0, limit) : items);
    }

    public List<LipSyncWrapper> filterLipSyncClasses(LipSyncWrapper currLipSyncWrapper, List<LipSyncWrapper> items, int state, int limit) {

        for (LipSyncWrapper item :  items) {

            float similarity = SimilarityVideo.calculateSimilarityWithLipSync(currLipSyncWrapper, item, state);
            item.setSimilarity(similarity);
        }

        Collections.sort(items);

        return (items.size() > limit ? items.subList(0, limit) : items);
    }



    private List<CoverWrapper> transformToCoverWrapperList(Cover currCover, List<Cover> covers, String recommendationClass) {

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

    private List<LipSyncWrapper> transformToLipSyncWrapperList(LipSync currLipSync, List<LipSync> lipSyncs, String recommendationClass) {

        List<LipSyncWrapper> lipSyncWrappers = new ArrayList<>();
        if (currLipSync != null && lipSyncs != null && lipSyncs.size() > 0) {

            for (LipSync lipSync : lipSyncs) {
                if (!currLipSync.equals(lipSync)) {
                    LipSyncWrapper lipSyncWrapper = videoService.getLipSyncWrapper(lipSync);
                    if (lipSyncWrapper != null) {
                        lipSyncWrapper.setRecommendationClass(recommendationClass);
                        lipSyncWrappers.add(lipSyncWrapper);
                    }
                }
            }
        }
        return lipSyncWrappers;
    }


    private void addRandomLipSyncs(List<LipSyncWrapper> sources, List<LipSyncWrapper> targets, int numNeedAdd) {

        if (sources == null) {
            return;
        }

        int numAdded = 0;
        while (numAdded < numNeedAdd && sources.size() > 0) {

            int rand = new Random().nextInt(sources.size());
            LipSyncWrapper randItem = sources.get(rand);
            if (!isExists(randItem, targets)) {
                targets.add(sources.get(rand));
                numAdded ++;
            }
            sources.remove(rand);
        }
    }

    private void addRandomCovers(List<CoverWrapper> sources, List<CoverWrapper> targets, int numNeedAdd) {

        if (sources == null) {
            return;
        }

        int numAdded = 0;
        while (numAdded < numNeedAdd && sources.size() > 0) {

            int rand = new Random().nextInt(sources.size());
            CoverWrapper randItem = sources.get(rand);
            if (!isExists(randItem, targets)) {
                targets.add(sources.get(rand));
                numAdded ++;
            }
            sources.remove(rand);
        }
    }


    private boolean isExists(LipSyncWrapper currLipSyncWrapper, List<LipSyncWrapper> checkList) {

        if (currLipSyncWrapper == null || currLipSyncWrapper.getLipSync() == null ||
                currLipSyncWrapper.getLipSync().getVideo() == null || checkList == null || checkList.size() == 0) {
            return false;
        }

        int currVideoId = currLipSyncWrapper.getLipSync().getVideo().getId();

        for (LipSyncWrapper item : checkList) {

            LipSync checkLipSync = item.getLipSync();
            if (checkLipSync != null && checkLipSync.getVideo() != null) {
                if (currVideoId == checkLipSync.getVideo().getId()) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isExists(CoverWrapper currCoverWrapper, List<CoverWrapper> checkList) {

        if (currCoverWrapper == null || currCoverWrapper.getCover() == null ||
                currCoverWrapper.getCover().getVideo() ==  null || checkList == null || checkList.size() == 0) {
            return false;
        }

        int currVideoId = currCoverWrapper.getCover().getVideo().getId();

        for (CoverWrapper item : checkList) {

            Cover checkCover = item.getCover();
            if (checkCover != null && checkCover.getVideo() != null) {
                if (currVideoId == checkCover.getVideo().getId()) {
                    return true;
                }
            }
        }

        return false;
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

            System.out.println("Size: " + lipSyncs.size());
            for (LipSync lipSync : lipSyncs)  {
                System.out.println("VideoId: " + lipSync.getVideo().getId());
                System.out.println("LipSync Name: " + lipSync.getLipSyncTemplate().getLipSyncTemplateName());
                System.out.println("LipSync owner: " + lipSync.getVideo().getAccount().getUsername());
                System.out.println("LipSync template id:" + lipSync.getLipSyncTemplate().getId());
                System.out.println("NumView: " + lipSync.getVideo().getNumView());
                System.out.println("-------------------------------------------------------------------------------------------");
            }
        }


    }

}
