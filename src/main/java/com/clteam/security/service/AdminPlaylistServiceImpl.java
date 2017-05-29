package com.clteam.security.service;

import com.clteam.model.Playlist;
import com.clteam.security.repository.AdminPlaylistRepository;
import com.clteam.security.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Khanh Nguyen on 22/5/2017.
 */
@Service
@Transactional
public class AdminPlaylistServiceImpl implements AdminPlaylistService {

    @Autowired
    private AdminPlaylistRepository adminPlaylistRepository;


    @Override
    public PaginationUtil<Playlist> pagingPlaylist(int currentPage) {
        return new PaginationUtil<Playlist>(adminPlaylistRepository.getQueryPlayListList(), currentPage);
    }
}
