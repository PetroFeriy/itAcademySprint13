package com.example.demo.service;

import java.util.List;

public interface BaseService<T> {

    T create(T entity);

    T findById(Long id);

    List<T> findAll();

    void delete(Long id);
}
