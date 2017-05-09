package com.clteam.services.userservice.api;

import com.clteam.model.Cover;

import java.util.List;

/**
 * Created by mrgnu on 29/04/2017.
 */
public interface HotCoverService {

    public List<Cover> getListHotCover(int limit);
}
