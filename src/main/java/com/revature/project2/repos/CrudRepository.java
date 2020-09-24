package com.revature.project2.repos;

import java.util.List;

public interface CrudRepository<T> {

    // Comment

    T save (T t);

    T findById (Integer id);

    List<T> findAll ();

    boolean update (T updateObj);

    boolean deleteById (Integer id);


}
