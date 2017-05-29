package com.clteam.services.commonservice.impl;

/**
 * Created by Dell on 23-May-17.
 */
/**
@Service
public class SearchServiceImpl2{

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

        calculateCoverSearchRank(searchList, coversByName, searchString, SEARCH_BY_NAME);
        calculateCoverSearchRank(searchList, coversByUser, searchString, SEARCH_BY_USER);
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

    public List<VideoWrapper> searchLipSyncs(String searchString, int limit) {

        List<LipSyncTemplateInfoEntity> templatesByName = searchRepo.searchLipSyncsByName(searchString, limit);
        List<LipSyncInfoEntity> lipSyncEntitiesByUser = searchRepo.searchLipSyncsByUser(searchString, limit);

        List<LipSync> lipSyncsByName = videoService.getLipSyncs(templatesByName, -1);
        List<LipSync> lipSyncsByUser = videoService.getLipSyncs(lipSyncEntitiesByUser);

        List<VideoWrapper> searchList = new ArrayList<>();
        List<VideoWrapper> result = new ArrayList<>();

        int numMerger = 2;
        // mergerLipSyncs(result, lipSyncsByName, lipSyncsByUser, numMerger);
        System.out.println("Merger : " + result.size());
        if (result.size() > 0) {
            System.out.println("Name first merger: " + result.get(0).getVideoName() + "-" + result.get(0).getVideo().getId());
        }

        calculateLipSyncSearchRank(searchList, lipSyncsByName, searchString, SEARCH_BY_NAME);
        calculateLipSyncSearchRank(searchList, lipSyncsByUser, searchString, SEARCH_BY_USER);
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

//    public List<VideoWrapper> searchLipSyncs2(String searchString, int limit) {
//
//        List<LipSyncTemplateInfoEntity> templatesByName = searchRepo.searchLipSyncsByName(searchString, limit);
//        List<LipSyncInfoEntity> lipSyncEntitiesByUser = searchRepo.searchLipSyncsByUser(searchString, limit);
//
//        List<LipSync> lipSyncsByName = videoService.getLipSyncs(templatesByName, -1);
//        List<LipSync> lipSyncsByUser = videoService.getLipSyncs(lipSyncEntitiesByUser);
//
//        lipSyncsByName = lipSyncsByName.size() > limit ? lipSyncsByName.subList(0, limit) : lipSyncsByName;
//
//        List<VideoWrapper> searchList = new ArrayList<>();
//        List<VideoWrapper> result = new ArrayList<>();
//
//    }

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

    public void mergerLipSyncs(List<VideoWrapper> list, List<LipSync> lipSyncs1, List<LipSync> lipSyncs2, int numMerger) {

        for (LipSync lipSync : lipSyncs1) {

            for (LipSync otherLipSync : lipSyncs2) {

                if (equals(lipSync, otherLipSync) == 1) {
                    int exists = isExists(list, lipSync);

                    // not exists then add to list
                    if (exists == 0) {
                        VideoWrapper videoWrapper = lipSync.toVideoWrapper();
                        list.add(videoWrapper);
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

    public int isExists(List<VideoWrapper> videoWrappers, LipSync checkLipSync) {

        if (checkLipSync == null || checkLipSync.getVideo() == null) {
            return -1;
        }
        for (VideoWrapper videoWrapper : videoWrappers) {

            if (videoWrapper.getVideo() != null && checkLipSync.getVideo().getId() == videoWrapper.getVideo().getId()) {
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

    public int equals(LipSync lipSync1, LipSync lipSync2) {

        if (lipSync1 == null || lipSync1.getVideo() == null || lipSync2 == null || lipSync2.getVideo() == null) {
            return -1;
        }

        if (lipSync1.getVideo().getId() == lipSync2.getVideo().getId()) {
            return 1;
        }

        return 0;
    }

    public void calculateCoverSearchRank(List<VideoWrapper> tempSearchList, List<Cover> covers, String searchString, int type) {

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


    public void calculateLipSyncSearchRank(List<VideoWrapper> tempSearchList, List<LipSync> lipSyncs, String searchString, int type) {

        System.out.println("Search String: " + searchString);
        if (lipSyncs != null) {
            if (type == SEARCH_BY_NAME) {
                System.out.println("Search LipSync By Name");
                for (LipSync lipSync : lipSyncs) {

                    float similarity = SimilarityVideo.similarityStrings(lipSync.getLipSyncTemplate().getLipSyncTemplateName(), searchString);
//                    float similarity2 = SimilarityVideo.similarityStrings()
                    VideoWrapper videoWrapper = lipSync.toVideoWrapper();
                    videoWrapper.setSimilarityWithOther(similarity);
                    tempSearchList.add(videoWrapper);

                    System.out.println("LipSync: " + videoWrapper.getVideoName() + " - " + lipSync.getVideo().getAccount().getFullname() + " - " + videoWrapper.getSimilarityWithOther());
                }

            } else if (type == SEARCH_BY_USER) {
                System.out.println("Search LipSync By User");
                for (LipSync lipSync : lipSyncs) {

                    float similarity = SimilarityVideo.similarityStrings(lipSync.getVideo().getAccount().getFullname(), searchString);
                    VideoWrapper videoWrapper = lipSync.toVideoWrapper();
                    videoWrapper.setSimilarityWithOther(similarity);
                    tempSearchList.add(videoWrapper);

                    System.out.println("LipSync: " + videoWrapper.getVideoName() + " - " + lipSync.getVideo().getAccount().getFullname() + " - " + videoWrapper.getSimilarityWithOther());
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

    public void indexSearchTables() {

        searchRepo.indexTables();
    }

    public List<VideoWrapper> searchInFields(String searchString, int limit) {

        List<CoverInfoEntity> coverInfoEntities = searchRepo.searchCoversInFields(searchString, limit);
        List<Cover> covers = videoService.getCovers(coverInfoEntities);
        List<VideoWrapper> result = new ArrayList<>();
        if (covers != null) {
            for (Cover cover : covers) {
                result.add(cover.toVideoWrapper());
            }
        }
        return result;
    }

    public List<VideoWrapper> searchLipSyncsInFields(String searchString, int limit) {
        List<LipSyncInfoEntity> lipSyncInfoEntities = searchRepo.searchLipSyncsInFields(searchString, limit);
        List<LipSync> lipSyncs = videoService.getLipSyncs(lipSyncInfoEntities);

        List<VideoWrapper> result = new ArrayList<>();
        if (lipSyncs != null) {

            for (LipSync lipSync : lipSyncs) {
                result.add(lipSync.toVideoWrapper());
            }
        }
        return result;
    }
}

*/