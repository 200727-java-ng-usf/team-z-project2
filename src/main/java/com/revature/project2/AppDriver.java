package com.revature.project2;

import com.revature.project2.models.User;
import com.revature.project2.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AppDriver {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        container.registerShutdownHook();

        UserService userService = container.getBean("userService", UserService.class);
        List<User> users = userService.findAll();
        users.forEach(System.out::println);

    }

}
