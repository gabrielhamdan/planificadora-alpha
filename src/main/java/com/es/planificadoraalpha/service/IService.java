package com.es.planificadoraalpha.service;

import jakarta.transaction.Transactional;

import java.util.List;

public interface IService<T> {

    public List<T> findAll();

    public T findById(int id);

    public T save(T t);

    public void deleteById(int id);

}
