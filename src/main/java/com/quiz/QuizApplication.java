package com.quiz;

import com.quiz.entity.FirstTime;
import com.quiz.entity.Role;
import com.quiz.entity.User;
import com.quiz.entity.UserRole;
import com.quiz.repo.FirstTimeRepository;
import com.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class QuizApplication implements CommandLineRunner {

    @Autowired
    private UserService service;

    @Autowired
    private FirstTimeRepository firstTimeRepository;

    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Application is running........");


        FirstTime first = this.firstTimeRepository.findById(1);

        FirstTime firstTime = null;

        if(first==null){

            firstTime = new FirstTime();

            firstTime.setId(1);
            firstTime.setFirstTime(true);

            this.firstTimeRepository.save(firstTime);

            User user = new User();

            user.setUsername("admin");
            user.setFirstName("Admin");
            user.setLastName("Admin");
            user.setEmail("admin@gmail.com");
            user.setNumber("985632100");
            user.setPassword("Admin@123");
            user.setProfile("admin.png");

            Role role = new Role();

            role.setRoleID(101);
            role.setRoleName("ADMIN");

            UserRole userRole = new UserRole();

            userRole.setRole(role);
            userRole.setUser(user);

            Set<UserRole> userRoleSet = new HashSet<>();

            userRoleSet.add(userRole);

            this.service.createUser(user, userRoleSet);


        }

    }
}
