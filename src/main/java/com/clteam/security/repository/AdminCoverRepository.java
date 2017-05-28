package com.clteam.security.repository;

import org.hibernate.Query;

/**
 * Created by Khanh Nguyen on 22/5/2017.
 */
public interface AdminCoverRepository {

    public Query getQueryCoverList();

    public Query getQueryCoverHotList();

    public Query getQueryCoverNewList();

}
