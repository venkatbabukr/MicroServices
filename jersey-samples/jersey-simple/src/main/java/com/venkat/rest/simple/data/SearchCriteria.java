package com.venkat.rest.simple.data;

public interface SearchCriteria<T> {

    boolean matchesEntity(T entity);

}
