package com.venkat.rest.simple.dto.out;

import java.util.List;

public class ListResponse<T> extends CountResponse {

    private List<T> list;

    public ListResponse() {
    }

    public ListResponse(List<T> lst) {
        this(lst, lst != null ? lst.size() : 0);
    }

    public ListResponse(List<T> lst, int totalCount) {
        super(totalCount);
        list = lst;
    }

    public List<T> getList() {
        return list;
    }

}
