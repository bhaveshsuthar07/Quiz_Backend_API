package com.quiz.service;

import com.quiz.entity.User;
import com.quiz.entity.UserRole;

import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User findUser(String username) throws Exception;

    public void deleteUser(long username) throws Exception;


}
