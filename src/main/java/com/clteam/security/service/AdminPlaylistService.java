package com.clteam.security.service;

import com.clteam.model.Playlist;
import com.clteam.security.util.PaginationUtil;

/**
 * Created by Khanh Nguyen on 22/5/2017.
 */
public interface AdminPlaylistService {

    public PaginationUtil<Playlist> pagingPlaylist(int currentPage);

}
