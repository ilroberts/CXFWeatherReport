package com.ilroberts.mapper;


import java.util.Optional;

public interface Mapper<T,C> {

    Optional<C> map(T source);
}
