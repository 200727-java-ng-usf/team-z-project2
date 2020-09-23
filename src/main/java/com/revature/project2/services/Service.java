package com.revature.project2.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Service<T> {

    // Comment

    // CRUD operations
    // save, find, update, delete

    Optional<T> save (T t);

    Optional<T> findById (Integer id);

    List<T> findAll ();

    boolean update (T t);

    boolean delete (T t);

}
