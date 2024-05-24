package com.quiz.controller;

import com.quiz.entity.Role;
import com.quiz.entity.User;
import com.quiz.entity.UserRole;
import com.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class _restController {

    @Autowired
    private UserService service;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        System.out.println("Create User function");

        Set<UserRole> userRoles = new HashSet<>();

        Role role = new Role();
        role.setRoleID(102);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoles.add(userRole);
        user.setUserRole(userRoles);


        return this.service.createUser(user,userRoles) ;
    }

    @GetMapping("/get/{username}")
    public User findUser(@PathVariable("username") String username) throws Exception {
        System.out.println("Get User function");
        return this.service.findUser(username);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id")long id) throws Exception {
        System.out.println("Delete User function");
        this.service.deleteUser(id);

    }
}
