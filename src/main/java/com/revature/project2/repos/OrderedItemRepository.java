package com.revature.project2.repos;

import com.revature.project2.models.OrderedItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class OrderedItemRepository implements CrudRepository<OrderedItem>  {

    @Override
    public Optional<OrderedItem> save(OrderedItem orderedItem) {
        return Optional.empty();
    }

    @Override
    public Optional<OrderedItem> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<OrderedItem> findAll() {
        return null;
    }

    @Override
    public boolean update(OrderedItem orderedItem) {
        return false;
    }

    @Override
    public boolean delete(OrderedItem orderedItem) {
        return false;
    }
}
