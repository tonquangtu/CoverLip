package com.clteam.security.service;

import com.clteam.model.Cover;
import com.clteam.security.util.PaginationUtil;

/**
 * Created by Khanh Nguyen on 22/5/2017.
 */
public interface AdminCoverService {

    public PaginationUtil<Cover> pagingCover(int currentPage);

}
