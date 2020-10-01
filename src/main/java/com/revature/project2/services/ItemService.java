package com.revature.project2.services;

import com.revature.project2.exceptions.InvalidRequestException;
import com.revature.project2.exceptions.ResourceNotFoundException;
import com.revature.project2.models.Genre;
import com.revature.project2.models.Item;
import com.revature.project2.models.Role;
import com.revature.project2.models.User;
import com.revature.project2.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    ItemRepository itemRepo;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepo = itemRepository;
    }

    /**
     * CREATE operation
     * @param newItem
     * @return
     */
    @Transactional
    public Item save(Item newItem) {
        return itemRepo.save(newItem).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * READ operation
     * @return
     */
    @Transactional(readOnly=true)
    public List<Item> findAll() {
        return itemRepo.findAll();
    }

    /**
     * READ operation
     * @param id
     * @return
     */
    @Transactional
    public Item findById(Integer id) {

        if (id <= 0) {
            throw new InvalidRequestException("ID cannot be negative or equal to zero");
        }

        return itemRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * READ operation
     * @param genre
     * @return
     */
    @Transactional
    public List<Item> findUsersByGenre(String genre) {
        Genre genreEnum = Genre.valueOf(genre.toUpperCase());
        return  itemRepo.findUsersByGenre(genreEnum);
    }

    /**
     * READ operation
     * @param name
     * @return
     */
    @Transactional
    public Item findUserByName(String name){
        return itemRepo.findUserByName(name).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * UPDATE operation
     * @param updateItem
     * @return
     */
    @Transactional
    public boolean update(Item updateItem) {
        return itemRepo.update(updateItem);
    }

    /**
     * DELETE operation
     * @param id
     * @return
     */
    @Transactional
    public boolean deleteById(Integer id) {

        if (id <= 0) {
            throw new InvalidRequestException("ID cannot be negative or equal to zero");
        }

        return itemRepo.deleteById(id);
    }


    /**
     * Convenience method
     * @param name
     * @return
     */
    @Transactional
    public boolean isNameValid(String name){
        return itemRepo.isNameValid(name);
    }
}