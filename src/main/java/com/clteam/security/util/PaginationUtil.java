package com.clteam.security.util;

import com.clteam.security.constant.SecurityConstant;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Khanh Nguyen on 21/5/2017.
 */
public class PaginationUtil<E> {

    private int currentPage;
    private int maxRecordPerPage;
    private int maxNumberPerPage;
    private int totalPage;
    private int totalRecord;
    private List<E> resultList;
    private boolean found = false;
    private List<Integer> indexPageList = new ArrayList<>();

    public PaginationUtil(Query query, int currentPage) {
        maxRecordPerPage = SecurityConstant.MAX_RECORD_PER_PAGE;
        maxNumberPerPage = SecurityConstant.MAX_NUM_PER_PAGE;
        paginationResult(query, currentPage);
        createListIndexPage();
    }

    public PaginationUtil(Query query, int currentPage, int maxNumberPerPage, int maxRecordPerPage) {
        this.currentPage = currentPage;
        this.maxNumberPerPage = maxNumberPerPage;
        this.maxRecordPerPage = maxRecordPerPage;
        paginationResult(query, currentPage);
        createListIndexPage();
    }

    private void createListIndexPage() {
        indexPageList.add(currentPage);
        int i = 1;
        int prev = currentPage - 1;
        int next = currentPage + 1;
        do {
            if (prev >= 1) {
                indexPageList.add(prev);
                ++i;
                --prev;
            }
            if (next <= totalPage) {
                indexPageList.add(next);
                ++i;
                ++next;
            }
            if (i == maxNumberPerPage) {
                break;
            }
        } while ((prev >= 1) || (next <= totalPage));
        Collections.sort(indexPageList);
    }

    private boolean paginationResult(Query query, int currentPage) {
        this.currentPage = currentPage;
        ScrollableResults resultScroll = query.scroll(ScrollMode.FORWARD_ONLY);
        List results = new ArrayList();
        resultScroll.last();
        this.totalRecord = resultScroll.getRowNumber() + 1;
        this.totalPage = totalRecord / maxRecordPerPage + ((totalRecord % maxRecordPerPage == 0) ? 0 : 1);
        if (currentPage > totalPage) {
            found = false;
        } else {
            boolean hasResult = resultScroll.first();
            if (hasResult) {
                int fromRecordIndex = (currentPage - 1) * maxRecordPerPage;
                int toRecordIndex = fromRecordIndex + maxRecordPerPage;
                hasResult = resultScroll.scroll(fromRecordIndex);
                if (hasResult) {
                    do {
                        E record = (E) resultScroll.get(0);
                        results.add(record);
                    } while(resultScroll.next()
                            && resultScroll.getRowNumber() >= fromRecordIndex
                            && resultScroll.getRowNumber() < toRecordIndex);
                }
            }
            this.resultList = results;
            found = true;
        }
        return found;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getMaxNumberPerPage() {
        return maxNumberPerPage;
    }

    public void setMaxNumberPerPage(int maxNumberPerPage) {
        this.maxNumberPerPage = maxNumberPerPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<E> getresultList() {
        return resultList;
    }

    public void setresultList(List<E> resultList) {
        this.resultList = resultList;
    }

    public int getMaxRecordPerPage() {
        return maxRecordPerPage;
    }

    public void setMaxRecordPerPage(int maxRecordPerPage) {
        this.maxRecordPerPage = maxRecordPerPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public List<Integer> getIndexPageList() {
        return indexPageList;
    }

    public void setIndexPageList(List<Integer> indexPageList) {
        this.indexPageList = indexPageList;
    }
}
