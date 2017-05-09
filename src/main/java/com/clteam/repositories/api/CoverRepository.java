package com.clteam.repositories.api;


import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.HotCoverEntity;

import java.util.List;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public interface CoverRepository {

    CoverInfoEntity getCoverInfo(int coverId);
    CoverInfoEntity getCoverInfoByVideoId(int videoId);

    List<HotCoverEntity> getAllHotCover(int limit);
}
