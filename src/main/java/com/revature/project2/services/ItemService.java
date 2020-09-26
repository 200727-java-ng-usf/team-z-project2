package com.revature.project2.services;

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


    @Transactional(readOnly=true)
    public List<Item> findAll() {
        return itemRepo.findAll();
    }

    @Transactional
    public Item save(Item newItem) {
        return itemRepo.save(newItem).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public Item findById(Integer id) {
        return itemRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public boolean update(Item updateItem) {
        return itemRepo.update(updateItem);
    }

    @Transactional
    public boolean deleteById(Integer id) {
        return itemRepo.deleteById(id);
    }

    @Transactional
    public List<Item> findUsersByGenre(String genre) {
        Genre genreEnum = Genre.valueOf(genre.toUpperCase());
        return  itemRepo.findUsersByGenre(genreEnum);
    }

    @Transactional
    public Item findUserByName(String name){
        return itemRepo.findUserByName(name).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public boolean isNameValid(String name){
        return itemRepo.isNameValid(name);
    }
}