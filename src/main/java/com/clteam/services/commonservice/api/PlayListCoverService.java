package com.clteam.services.commonservice.api;

import com.clteam.model.Playlist;

import java.util.List;

/**
 * Created by mrgnu on 04/05/2017.
 */
public interface PlayListCoverService {

    public List<Playlist> getListPlayListCover(int limit);
}
