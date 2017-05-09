package com.clteam.services.userservice.api;


import com.clteam.dataobject.TopCoverIdolEntity;
import com.clteam.model.TopIdol;

import java.util.List;

/**
 * Created by mrgnu on 30/04/2017.
 */
public interface TopIdolService {

    public List<TopIdol> getListTopCoverIdols(int limit);
}
