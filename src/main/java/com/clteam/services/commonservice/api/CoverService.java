package com.clteam.services.commonservice.api;

import com.clteam.model.Cover;
import com.clteam.model.Playlist;

import java.util.List;

/**
 * Created by mrgnu on 19/05/2017.
 */
public interface CoverService {

    public List<Cover> getListHotCover(int limit);

    public List<Cover> getListNewCover(int limit);

    public List<Playlist> getListPlayListCover(int limit);

    public List<Cover> getListNewCover(int limit, int currentVideoId);
}
