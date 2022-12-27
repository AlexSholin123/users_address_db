package ua.sholin.databasepractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.sholin.databasepractice.models.Address;
import ua.sholin.databasepractice.models.Users;
import ua.sholin.databasepractice.service.UserService;

@SpringBootApplication
public class DatabasePracticeApplication {

//    @Autowired
//    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(DatabasePracticeApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void testJpaMethods(){
//        Address address = new Address();
//        address.setCity("Kiev");
//        address.setHomeNumber("4");
//        address.setStreet("Main Street");
//        Address address1 = new Address();
//        address1.setCity("Lviv");
//        Users users = new Users();
//        users.setAddress(address);
//        users.setEmail("someEmail@gmail.com");
//        users.setName("Smith");
//        userService.createUsers(users);
//        Users users1 = new Users();
//        users1.setName("Jon Dorian");
//        users1.setEmail("gmailEmail@gmail.com");
//        users1.setAddress(address1);
//        userService.createUsers(users1);
//
//        userService.findAll().forEach(System.out::println);
//
//        userService.findAllByName("Smith").forEach(System.out::println);
//
//        userService.findWhereEmailIsGmail().forEach(System.out::println);
//
//        userService.findWhereNameStartsFromSmith().forEach(System.out::println);
//    }

}
