package com.clteam.services.commonservice.impl;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.LipSyncInfoEntity;
import com.clteam.model.*;
import com.clteam.repositories.impl.SearchRepositoryImpl;
import com.clteam.services.commonservice.api.VideoService;
import com.clteam.utils.CommonUtils;
import com.clteam.utils.SimilarityVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 23-May-17.
 */
@Service
public class SearchServiceImpl{

    @Autowired
    VideoService videoService;

    @Autowired
    SearchRepositoryImpl searchRepo;

    public static final int SEARCH_BY_NAME = 1;

    public static final int SEARCH_BY_USER = 2;


    public static final int SEARCH_COVER = 1;

    public static final int SEARCH_LIP_SYNC = 2;


    public SearchData search(String searchString, int searchType, int limit) {

        if (limit < 2 || limit > 50) {
            limit = 6;
        }
        searchString = standardSearchString(searchString);
        SearchData searchData = new SearchData();

        if (searchString != null && searchString.length() > 0) {

            int limitSearchAcc = limit / 2;
            int limitSearchVideo = limit;

            List<VideoWrapper> videoSearchResults;
            if (searchType == SEARCH_COVER) {
                videoSearchResults = searchCovers(searchString, limitSearchVideo);
            } else {
                videoSearchResults = searchLipSyncs(searchString, limitSearchVideo);
            }

            List<Account> accSearchResults = searchUsers(searchString, limitSearchAcc);

            VideoWrapper firstSearchVideo = null;
            Account firstSearchAcc = null;
            if (videoSearchResults != null && videoSearchResults.size() > 0) {
                firstSearchVideo = videoSearchResults.get(0);
            }

            if (accSearchResults != null && accSearchResults.size() > 0) {
                firstSearchAcc = accSearchResults.get(0);
            }

            if (firstSearchVideo != null && firstSearchAcc != null) {

                float firstSearchVideoRank1 = SimilarityVideo.similarityStrings(searchString, firstSearchVideo.getVideoName());
//                float firstSearchVideoRank2 = SimilarityVideo.similarityStrings(searchString, firstSearchVideo.getVideo().getAccount().getFullname());
                String tempString3 = firstSearchVideo.getVideoName() + " " + firstSearchVideo.getVideo().getAccount().getFullname();
                float firstSearchVideoRank3 = SimilarityVideo.similarityStrings(searchString, tempString3);

                float firstSearchVideoRank = firstSearchVideoRank1 > firstSearchVideoRank3 ? firstSearchVideoRank1 : firstSearchVideoRank3;
//                firstSearchVideoRank = firstSearchVideoRank > firstSearchVideoRank3 ? firstSearchVideoRank : firstSearchVideoRank3;

                float firstSearchAccRank = SimilarityVideo.similarityStrings(searchString, firstSearchAcc.getFullname());

                if (firstSearchVideoRank >= firstSearchAccRank) {
                    searchData.setBestVideoSearch(firstSearchVideo);
                    searchData.setBestSearchType(SearchData.BEST_VIDEO_SEARCH);

                } else {
                    searchData.setBestAccountSearch(firstSearchAcc);
                    searchData.setBestSearchType(SearchData.BEST_ACC_SEARCH);
                }

            } else if (firstSearchVideo != null) {
                searchData.setBestVideoSearch(firstSearchVideo);
                searchData.setBestSearchType(SearchData.BEST_VIDEO_SEARCH);

            } else if (firstSearchAcc != null) {
                searchData.setBestAccountSearch(firstSearchAcc);
                searchData.setBestSearchType(SearchData.BEST_ACC_SEARCH);
            }

            searchData.setVideoSearchList(videoSearchResults);
            searchData.setAccountSearchList(accSearchResults);
        }

        return searchData;
    }

    public List<Account> searchUsers(String searchString, int limit) {

        List<AccountEntity> accountEntities = searchRepo.searchUsers(searchString, limit);
        List<Account> result = new ArrayList<>();
        if (accountEntities != null) {

            for (AccountEntity accountEntity : accountEntities) {
                Account account = new Account();
                account.copyData(accountEntity);
                result.add(account);
            }
        }
        return result;
    }

    public List<VideoWrapper> searchCovers(String searchString, int limit) {

        List<CoverInfoEntity> coverInfoEntities = searchRepo.searchCovers(searchString, limit);
        List<Cover> covers = videoService.getCovers(coverInfoEntities);
        List<VideoWrapper> result = new ArrayList<>();
        if (covers != null) {
            for (Cover cover : covers) {
                if (cover != null) {
                    result.add(cover.toVideoWrapper());
                }
            }
        }
        return result;
    }

    public List<VideoWrapper> searchLipSyncs(String searchString, int limit) {
        List<LipSyncInfoEntity> lipSyncInfoEntities = searchRepo.searchLipSyncs(searchString, limit);
        List<LipSync> lipSyncs = videoService.getLipSyncs(lipSyncInfoEntities);

        List<VideoWrapper> result = new ArrayList<>();
        if (lipSyncs != null) {

            for (LipSync lipSync : lipSyncs) {
                if (lipSync != null) {
                    result.add(lipSync.toVideoWrapper());
                }
            }
        }
        return result;
    }


    public String standardSearchString(String searchString) {

        if (searchString != null) {
            searchString = CommonUtils.trimExcessWhiteSpace(searchString);
            if (searchString.length() > 100) {
                String [] searchArr = searchString.split(" ");
                int limitSearchWords = 10;
                StringBuilder searchStringBuilder = new StringBuilder();
                int length = searchArr.length - 1;
                for (int i = 0; i < limitSearchWords && i < length; i++) {
                    searchStringBuilder.append(searchArr[i] + " ");
                }
                searchStringBuilder.append(searchArr[searchArr.length -1]);
                searchString = searchStringBuilder.toString();
            }

        }

        return searchString;
    }

    public void indexSearchTables() {

        searchRepo.indexTables();
    }


}
