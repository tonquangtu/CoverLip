package com.clteam.services.commonservice.impl;

import com.clteam.dataobject.AccountEntity;
import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.VideoInfoEntity;
import com.clteam.model.Account;
import com.clteam.model.Cover;
import com.clteam.model.SearchData;
import com.clteam.model.VideoWrapper;
import com.clteam.repositories.impl.SearchRepositoryImpl;
import com.clteam.services.commonservice.api.VideoService;
import com.clteam.utils.CommonUtils;
import com.clteam.utils.SimilarityVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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


    public SearchData search(String searchString, int limit) {

        if (limit < 2 || limit > 50) {
            limit = 6;
        }
        searchString = standardSearchString(searchString);
        SearchData searchData = new SearchData();

        if (searchString != null && searchString.length() > 0) {

            int limitSearchAcc = limit / 2;
            int limitSearchVideo = limit;

            List<VideoWrapper> videoSearchResults = searchCovers(searchString, limitSearchVideo);
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

    public List<VideoWrapper> searchCovers(String searchString, int limit) {

        List<CoverInfoEntity> coverInfoEntitiesByName = searchRepo.searchCoversByName(searchString, limit);
        List<CoverInfoEntity> coverEntitiesByUser = searchRepo.searchCoversByUser(searchString, limit);

        List<Cover> coversByName = videoService.getCovers(coverInfoEntitiesByName);
        List<Cover> coversByUser = videoService.getCovers(coverEntitiesByUser);
        List<VideoWrapper> searchList = new ArrayList<>();
        List<VideoWrapper> result = new ArrayList<>();

        int numMerger = 2;
        mergerCovers(result, coversByName, coversByUser, numMerger);
        System.out.println("Merger : " + result.size());

        calculateSearchRank(searchList, coversByName, searchString, SEARCH_BY_NAME);
        calculateSearchRank(searchList, coversByUser, searchString, SEARCH_BY_USER);
        Collections.sort(searchList);

        for (VideoWrapper videoWrapper : searchList) {

            if (isExists(result, videoWrapper) == 0) {
                result.add(videoWrapper);
                if (result.size() >= limit) {
                    break;
                }
            }
        }
        return result;
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

    public List<Cover> getCovers(List<VideoInfoEntity> videoInfoEntities) {

        List<Cover> covers = new ArrayList<>();
        for (VideoInfoEntity videoEntity : videoInfoEntities) {

            Cover cover = videoService.getCoverInfo(videoEntity);
            if (cover != null) {
                covers.add(cover);
            }
        }
        return covers;
    }

    public void mergerCovers(List<VideoWrapper> list, List<Cover> covers1, List<Cover> covers2, int numMerger) {

        for (Cover cover : covers1) {

            for (Cover otherCover : covers2) {

                if (equals(cover, otherCover) == 1) {
                    int exists = isExists(list, cover);
                    if (exists == 0) {
                        list.add(cover.toVideoWrapper());
                        if (list.size() >= numMerger) {
                            return;
                        }
                        break;
                    }
                }
            }
        }
    }

    public int isExists(List<VideoWrapper> videoWrappers, Cover checkCover) {

        if (checkCover == null || checkCover.getVideo() == null) {
            return -1;
        }
        for (VideoWrapper videoWrapper : videoWrappers) {

            if (videoWrapper.getVideo() != null && checkCover.getVideo().getId() == videoWrapper.getVideo().getId()) {
                return 1;
            }
        }
        return 0;
    }

    public int isExists(List<VideoWrapper> videoWrappers, VideoWrapper checkVideo) {

        if (checkVideo == null || checkVideo.getVideo() == null) {
            return -1;
        }
        for (VideoWrapper videoWrapper : videoWrappers) {

            if (videoWrapper.getVideo() != null && checkVideo.getVideo().getId() == videoWrapper.getVideo().getId()) {
                return 1;
            }
        }
        return 0;
    }

    public int equals(Cover cover1, Cover cover2) {

        if (cover1 == null || cover1.getVideo() == null || cover2 == null || cover2.getVideo() == null) {
            return -1;
        }

        if (cover1.getVideo().getId() == cover2.getVideo().getId()) {
            return 1;
        }

        return 0;
    }

    public void calculateSearchRank(List<VideoWrapper> tempSearchList, List<Cover> covers, String searchString, int type) {

        if (covers != null) {
            if (type == SEARCH_BY_NAME) {
                for (Cover cover : covers) {

                    float similarity = SimilarityVideo.similarityStrings(cover.getCoverName(), searchString);
                    VideoWrapper videoWrapper = cover.toVideoWrapper();
                    videoWrapper.setSimilarityWithOther(similarity);
                    tempSearchList.add(videoWrapper);
                }

            } else if (type == SEARCH_BY_USER) {

                for (Cover cover : covers) {

                    float similarity = SimilarityVideo.similarityStrings(cover.getVideo().getAccount().getFullname(), searchString);
                    VideoWrapper videoWrapper = cover.toVideoWrapper();
                    videoWrapper.setSimilarityWithOther(similarity);
                    tempSearchList.add(videoWrapper);
                }
            }
        }
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

}
