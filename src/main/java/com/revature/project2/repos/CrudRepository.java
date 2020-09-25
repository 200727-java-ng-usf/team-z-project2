package com.revature.project2.repos;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    // Comment

    Optional<T> save (T t);

    Optional<T> findById (Integer id);

    List<T> findAll ();

    boolean update (T updateObj);

    boolean deleteById (Integer id);


}
