package com.clteam.repositories.api;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public interface CoverRepository {

    CoverInfo getCoverInfo(int coverId);
    CoverInfo getCoverInfoByVideoId(int videoId);


}
