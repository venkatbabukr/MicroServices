package com.venkat.rest.simple.dto;

import java.util.List;

import com.venkat.rest.simple.data.SearchCriteria;

public class SearchResponse<T> extends ListResponse<T> {

    private SearchCriteria<T> searchCriteria;

    public SearchResponse() { }

    public SearchResponse(SearchCriteria<T> sc, List<T> results) {
        super(results);
        this.searchCriteria = sc;
    }

    public SearchCriteria<T> getSearchCriteria() {
        return searchCriteria;
    }

}
