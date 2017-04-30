package com.clteam.repositories.api;


import com.clteam.dataobject.CoverInfoEntity;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public interface CoverRepository {

    CoverInfoEntity getCoverInfo(int coverId);
    CoverInfoEntity getCoverInfoByVideoId(int videoId);


}
