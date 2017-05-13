package com.clteam.services.userservice.api;

import com.clteam.model.Cover;

import java.util.List;

/**
 * Created by nguyenthanhtung on 02/05/2017.
 */
public interface HotCoverService {
    public List<Cover> getListHotCover(int limit);
}
