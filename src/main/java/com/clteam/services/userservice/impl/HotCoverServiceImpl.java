package com.clteam.services.userservice.impl;

import com.clteam.model.Cover;
import com.clteam.repositories.api.CoverRepository;
import com.clteam.services.userservice.api.HotCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nguyenthanhtung on 02/05/2017.
 */
@Service
public class HotCoverServiceImpl implements HotCoverService{
    @Autowired
    private CoverRepository coverRepository;
    public List<Cover> getListHotCover(int limit) {
        //To do
        return null;
    }
}
