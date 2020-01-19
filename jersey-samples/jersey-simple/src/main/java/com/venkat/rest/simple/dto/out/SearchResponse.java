package com.venkat.rest.simple.dto.out;

import java.util.List;

import com.venkat.rest.simple.dto.in.ISearchInput;

public class SearchResponse<T> extends ListResponse<T> {

    private ISearchInput<T> searchCriteria;

    public SearchResponse() { }

    public SearchResponse(ISearchInput<T> sc, List<T> results) {
        super(results);
        this.searchCriteria = sc;
    }

    public ISearchInput<T> getSearchCriteria() {
        return searchCriteria;
    }

}
