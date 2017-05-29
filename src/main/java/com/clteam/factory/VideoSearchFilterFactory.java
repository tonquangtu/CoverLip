package com.clteam.factory;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.hibernate.search.annotations.Factory;
import org.hibernate.search.annotations.Key;
import org.hibernate.search.filter.FilterKey;
import org.hibernate.search.filter.StandardFilterKey;

/**
 * Created by Dell on 23-May-17.
 */
public class VideoSearchFilterFactory {

    private Integer type;

    /**
     * injected parameter
     */
    public void setType(Integer type) {
        this.type = type;
    }

    @Key
    public FilterKey getKey() {
        StandardFilterKey key = new StandardFilterKey();
        key.addParameter( type );
        return key;
    }

    @Factory
    public Filter getFilter() {
        Query query = new TermQuery( new Term("type", type.toString() ) );
        return new CachingWrapperFilter( new QueryWrapperFilter(query) );
    }
}
