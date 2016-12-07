package com.example.decode.dcgram_android.domain.repository;

/**
 * Created by root on 06.12.16..
 */

public interface Repository<T> {

    boolean insert(T model);

    boolean update(T model);

    T get(Object id);

    boolean delete(T model);
}
