package com.revature.project2;

//import com.revature.project2.models.Item;
import com.revature.project2.models.*;
//import com.revature.project2.services.ItemService;
import com.revature.project2.services.ItemService;
import com.revature.project2.services.OrderService;
import com.revature.project2.services.OrderedItemService;
import com.revature.project2.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AppDrive {

    public static void main(String[] args) {



        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        container.registerShutdownHook();

        UserService userService = container.getBean("userService", UserService.class);
//        List<User> users = userService.findAll();
//
//        users.forEach(System.out::println);
//
//        User findUser = userService.findById(2);
//        System.out.println(findUser.getUsername());
//        findUser.setEmail("ppp@gmail.com");
//        userService.update(findUser);
//        System.out.println(userService.findById(2));

//        userService.deleteById(2);




//
//        User newUser = userService.save(new User("aaa","bbb","ccc","ddd","eee@gmail",Role.USER));
//        System.out.println(newUser.toString());

        User authUser = userService.findUserByUsernameAndPassword("aaa","bbb");
        System.out.println("Auth User : " + authUser.toString());

//        User newUser = userService.findById(1);
//        newUser.setEmail("ppp@gmail.com");
//        userService.update(newUser);
//        User newUser2 = userService.findById(2);
//        System.out.println(newUser2.toString());


//        ItemService itemService = container.getBean("itemService", ItemService.class);
//        List<Item> items = itemService.findAll();
//        items.forEach(System.out::println);
//
//        OrderService orderService = container.getBean("orderService", OrderService.class);
//        List<Order> orders = orderService.findAll();
//        orders.forEach(System.out::println);
//
//        OrderedItemService  orderedItemService = container.getBean("orderedItemService",  OrderedItemService.class);
//        List<OrderedItem> orderedItemList = orderedItemService.findAll();
//        orderedItemList.forEach(System.out::println);

    }
}
