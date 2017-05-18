package com.clteam.services.commonservice.api;

import com.clteam.model.Cover;

import java.util.List;

/**
 * Created by nguyenthanhtung on 25/04/2017.
 */
public interface NewCoverService {
    public List<Cover> getListNewCover(int limit);
}
