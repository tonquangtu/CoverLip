package com.clteam.repositories.api;

import com.clteam.dataobject.CoverInfo;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public interface CoverRepository {

    CoverInfo getCoverInfo(int coverId);
    CoverInfo getCoverInfoByVideoId(int videoId);


}
