package com.clteam.security.service;

import com.clteam.dataobject.HotCoverEntity;
import com.clteam.dataobject.NewCoverEntity;
import com.clteam.model.Cover;
import com.clteam.security.util.PaginationUtil;

/**
 * Created by Khanh Nguyen on 22/5/2017.
 */
public interface AdminCoverService {

    public PaginationUtil<Cover> pagingCover(int currentPage);

    public PaginationUtil<HotCoverEntity> pagingHotCover(int currentPage);

    public PaginationUtil<NewCoverEntity> pagingNewCover(int currentPage);

}
