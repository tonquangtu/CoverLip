package com.clteam.services.commonservice.api;

import com.clteam.model.Cover;
import com.clteam.model.LipSync;
import com.clteam.model.User;

import java.util.List;

/**
 * Created by Dell on 09-May-17.
 */
public interface RecommenderService {

    public List<Cover> recommendCovers(Cover currCover, User user, int limit);

    public List<LipSync> recommendLipSyncs(LipSync currLipSync, User user, int limit);
}
