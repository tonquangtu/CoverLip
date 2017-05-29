package com.clteam.security.service;

import com.clteam.dataobject.HotCoverEntity;
import com.clteam.dataobject.NewCoverEntity;
import com.clteam.model.Cover;
import com.clteam.security.repository.AdminCoverRepository;
import com.clteam.security.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Khanh Nguyen on 22/5/2017.
 */
@Service
@Transactional
public class AdminCoverServiceImpl implements AdminCoverService {

    @Autowired
    private AdminCoverRepository adminCoverRepository;


    @Override
    public PaginationUtil<Cover> pagingCover(int currentPage) {
        return new PaginationUtil(adminCoverRepository.getQueryCoverList(), currentPage);
    }

    @Override
    public PaginationUtil<HotCoverEntity> pagingHotCover(int currentPage) {
        return new PaginationUtil<HotCoverEntity>(adminCoverRepository.getQueryCoverHotList(), currentPage);
    }

    @Override
    public PaginationUtil<NewCoverEntity> pagingNewCover(int currentPage) {
        return new PaginationUtil<NewCoverEntity>(adminCoverRepository.getQueryCoverNewList(), currentPage);
    }
}
