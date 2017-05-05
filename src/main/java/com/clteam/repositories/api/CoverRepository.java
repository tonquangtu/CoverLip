package com.clteam.repositories.api;


import com.clteam.dataobject.CoverInfoEntity;
import com.clteam.dataobject.NewCoverEntity;
import com.clteam.model.Cover;

import java.util.List;

/**
 * Created by nguyenthanhtung on 27/04/2017.
 */
public interface CoverRepository {

    CoverInfoEntity getCoverInfo(int coverId);
    CoverInfoEntity getCoverInfoByVideoId(int videoId);

    List<NewCoverEntity> getListNewCover(int limit);
    List<Cover> getListHotCover(int limit);
}
