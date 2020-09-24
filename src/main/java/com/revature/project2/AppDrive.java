package com.revature.project2;

//import com.revature.project2.models.Item;
import com.revature.project2.models.Item;
import com.revature.project2.models.Order;
import com.revature.project2.models.OrderedItem;
import com.revature.project2.models.User;
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
        List<User> users = userService.findAll();
        users.forEach(System.out::println);

        ItemService itemService = container.getBean("itemService", ItemService.class);
        List<Item> items = itemService.findAll();
        items.forEach(System.out::println);

        OrderService orderService = container.getBean("orderService", OrderService.class);
        List<Order> orders = orderService.findAll();
        orders.forEach(System.out::println);

        OrderedItemService  orderedItemService = container.getBean("orderedItemService",  OrderedItemService.class);
        List<OrderedItem> orderedItemList = orderedItemService.findAll();
        orderedItemList.forEach(System.out::println);

    }
}
