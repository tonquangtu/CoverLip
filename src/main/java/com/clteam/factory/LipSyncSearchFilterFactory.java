package com.clteam.factory;

import org.apache.lucene.search.CachingWrapperFilter;
import org.apache.lucene.search.Filter;
import org.hibernate.search.annotations.Factory;

/**
 * Created by Dell on 23-May-17.
 */
public class LipSyncSearchFilterFactory {

    @Factory
    public Filter getFilter() {
        //some additional steps to cache the filter results per IndexReader
        Filter bestDriversFilter = new LipSyncSearchFilter();
        return new CachingWrapperFilter(bestDriversFilter);
    }
}
