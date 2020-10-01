package com.revature.project2.services;

import com.revature.project2.exceptions.InvalidRequestException;
import com.revature.project2.exceptions.ResourceNotFoundException;
import com.revature.project2.models.Genre;
import com.revature.project2.models.Item;
import com.revature.project2.repos.ItemRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ItemServiceTest {

    private ItemService itemService;
    private ItemRepository mockItemRepo = Mockito.mock(ItemRepository.class);
    List<Item> mockItems = new ArrayList<>();


    @Before
    public void setUp() throws Exception {

        itemService = new ItemService(mockItemRepo);
        mockItems.add(new Item(1,"item1",100.00,10,"first item","url1", Genre.SUN));

        mockItems.add(new Item(2,"item2",200.00,20,"second item","url2", Genre.COWBOY));

        mockItems.add(new Item(3,"item3",300.00,30,"third item","url3", Genre.VISOR));
    }

    @After
    public void tearDown() throws Exception {

       itemService = null;
        mockItems.removeAll(mockItems);
    }

    @Test (expected = ResourceNotFoundException.class)
    public void save() {

     itemService.save(null);


    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void findAll() {
       itemService.findAll().get(0);

    }

    @Test (expected = InvalidRequestException.class)
    public void findById() {

        itemService.findById(-1);
    }

    @Test (expected = NullPointerException.class)
    public void findUsersByGenre() {
      when(mockItemRepo.findUsersByGenre(Genre.SUN)).thenReturn(null);
        assertNull(itemService.findUsersByGenre("SUN").get(1));
    }

    @Test (expected = RuntimeException.class)
    public void findUserByName() {
        itemService.findUserByName(null);
        System.out.println(itemService.findUserByName("item1").toString());

    }

    @Test
    public void update() {
        assertFalse(itemService.update(mockItems.get(0)));

    }

    @Test (expected = InvalidRequestException.class)
    public void deleteById() {
        assertFalse(itemService.deleteById(-99));
    }

    @Test
    public void isNameValid() {

        assertFalse(itemService.isNameValid("3344"));
    }
}