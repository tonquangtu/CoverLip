package com.clteam.model;

import java.util.List;

/**
 * Created by nguyenthanhtung on 29/05/2017.
 */
public class RawSearchData<E> {

    private int totalResult;

    List<E> rawData;

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public List<E> getRawData() {
        return rawData;
    }

    public void setRawData(List<E> rawData) {
        this.rawData = rawData;
    }
}
