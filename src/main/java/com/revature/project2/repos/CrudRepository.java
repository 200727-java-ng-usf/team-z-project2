package com.revature.project2.repos;

import java.util.Set;

public interface CrudRepository<T> {

    // Comment

    T save (T t);

    T findById (Integer id);

    Set<T> findAll ();

    boolean update (T t);

    boolean delete (T t);


}
