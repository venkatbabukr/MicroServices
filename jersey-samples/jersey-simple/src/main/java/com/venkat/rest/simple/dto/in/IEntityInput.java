package com.venkat.rest.simple.dto.in;

public interface IEntityInput<T> {

    public T toEntity();

    public T patchEntity(T entity, boolean patchUpdate);

}
