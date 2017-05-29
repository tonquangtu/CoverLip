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

    public static final int EXPECTED_VIDEO = 1;

    public static final int EXPECTED_USER = 2;

    public static final int EXPECTED_ALL = 3;

    public static final int NUM_ITEM_IN_PAGE = 9;

    public SearchData search(String searchString, int searchType, int limit) {

        if (limit!=-1&&(limit < 2 || limit > 50)) {
            limit = 6;
        }
        searchString = standardSearchString(searchString);
        SearchData searchData = new SearchData();

        if (searchString != null && searchString.length() > 0) {

            int limitSearchAcc = limit / 2;
            int limitSearchVideo = limit;

            List<VideoWrapper> videoSearchResults;
            if (searchType == SEARCH_COVER) {
                videoSearchResults = searchCovers(searchString, limitSearchVideo, 0).getRawData();
            } else {
                videoSearchResults = searchLipSyncs(searchString, limitSearchVideo, 0).getRawData();
            }

            List<Account> accSearchResults = doSearchUsers(searchString, limitSearchAcc, 0).getRawData();

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

    public SearchData searchVideos(String searchString, int searchType, int limit, int currentPage) {

        if (limit!=-1 &&(limit < 2 || limit > 50)) {
            limit = 6;
        }
        if (currentPage < 1 || currentPage > 100) {
            currentPage = 1;
        }
        int firstItemIndex = (currentPage - 1) * NUM_ITEM_IN_PAGE;
        searchString = standardSearchString(searchString);
        SearchData searchData = new SearchData();
        List<VideoWrapper> videoSearchResults;
        RawSearchData<VideoWrapper> rawSearchData;
        if (searchType == SEARCH_COVER) {
            rawSearchData = searchCovers(searchString, limit, firstItemIndex);
        } else {
            rawSearchData = searchLipSyncs(searchString, limit, firstItemIndex);
        }

        searchData.setVideoSearchList(rawSearchData.getRawData());
        searchData.setTotalVideo(rawSearchData.getTotalResult());
        return searchData;

    }

    public SearchData searchUsers(String searchString, int limit, int currentPage) {
        if (limit!=-1&&(limit < 2 || limit > 50)) {
            limit = 6;
        }
        if (currentPage < 1 || currentPage > 100) {
            currentPage = 1;
        }
        int firstItemIndex = (currentPage - 1) * NUM_ITEM_IN_PAGE;
        searchString = standardSearchString(searchString);
        RawSearchData<Account> rawSearchData;
        rawSearchData = doSearchUsers(searchString, limit, firstItemIndex);
        SearchData searchData = new SearchData();
        searchData.setAccountSearchList(rawSearchData.getRawData());
        searchData.setTotalAccount(rawSearchData.getTotalResult());

        return searchData;
    }

    public RawSearchData<Account> doSearchUsers(String searchString, int limit, int firstItemIndex) {

        RawSearchData<Account> returnData = new RawSearchData<>();
        RawSearchData<AccountEntity> rawSearchData = searchRepo.searchUsers(searchString, limit, firstItemIndex);

        List<AccountEntity> accountEntities = rawSearchData.getRawData();

        List<Account> result = new ArrayList<>();

        if (accountEntities != null) {

            for (AccountEntity accountEntity : accountEntities) {
                Account account = new Account();
                account.copyData(accountEntity);
                result.add(account);
            }
        }
        returnData.setRawData(result);
        returnData.setTotalResult(rawSearchData.getTotalResult());
        return returnData;
    }

    public RawSearchData<VideoWrapper> searchCovers(String searchString, int limit, int firstItemIndex) {

        RawSearchData<CoverInfoEntity> rawSearchData = searchRepo.searchCovers(searchString, limit, firstItemIndex);
        RawSearchData<VideoWrapper> returnData = new RawSearchData<>();
        List<Cover> covers = videoService.getCovers(rawSearchData.getRawData());
        List<VideoWrapper> result = new ArrayList<>();
        if (covers != null) {
            for (Cover cover : covers) {
                if (cover != null) {
                    result.add(cover.toVideoWrapper());
                }
            }
        }
        returnData.setRawData(result);
        returnData.setTotalResult(rawSearchData.getTotalResult());
        return returnData;
    }

    public RawSearchData<VideoWrapper> searchLipSyncs(String searchString, int limit, int firstItemIndex) {

        RawSearchData<VideoWrapper> returnData = new RawSearchData<>();
        RawSearchData<LipSyncInfoEntity> rawSearchData = searchRepo.searchLipSyncs(searchString, limit, firstItemIndex);
        List<LipSync> lipSyncs = videoService.getLipSyncs(rawSearchData.getRawData());

        List<VideoWrapper> result = new ArrayList<>();
        if (lipSyncs != null) {

            for (LipSync lipSync : lipSyncs) {
                if (lipSync != null) {
                    result.add(lipSync.toVideoWrapper());
                }
            }
        }

        returnData.setTotalResult(rawSearchData.getTotalResult());
        returnData.setRawData(result);
        return returnData;
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
