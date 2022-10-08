package com.crossguild.elearning.service;

import java.util.List;
import java.util.Optional;

public interface Service<T, K> {

    List<T> getAll();

    Optional<T> getById(K id);

    T save(T entity);

    void deleteById(K id);
}