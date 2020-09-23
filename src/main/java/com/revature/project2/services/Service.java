package com.revature.project2.services;

import java.util.Set;

public interface Service<T> {

    // CRUD operations
    // save, find, update, delete

    T save (T t);

    T findById (Integer id);

    Set<T> findAll ();

    boolean update (T t);

    boolean delete (T t);

}
