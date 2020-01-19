package com.venkat.rest.simple.dto.in;

public interface ISearchInput<T> {

    boolean matchEntity(T entity);

}
