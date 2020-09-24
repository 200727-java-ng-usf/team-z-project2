package com.revature.project2.repos;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {

    // Comment

    Optional<T> save (T t);

    Optional<T> findById (Integer id);

    List<T> findAll ();

    boolean update (T t);

    boolean delete (T t);


}
