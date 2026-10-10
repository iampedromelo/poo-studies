package org.example;

import java.util.ArrayList;

public interface Repository<T, K> {

    void save(T entity);
    T getById(K id);
    ArrayList<T> getAll();

}
