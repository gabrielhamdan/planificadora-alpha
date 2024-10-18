package com.es.planificadoraalpha.services;

import java.util.List;

public interface ICrudService<T> {

    public List<T> findAll();

    public T findById(int id);

    public T save(T t);

    public void deleteById(int id);

}
