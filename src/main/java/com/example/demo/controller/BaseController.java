package com.example.demo.controller;

import java.util.List;

public interface BaseController<T> {

    List<T> getAll();

    T getById(Long id);

    T create(T entity);

    void delete(Long id);
}
