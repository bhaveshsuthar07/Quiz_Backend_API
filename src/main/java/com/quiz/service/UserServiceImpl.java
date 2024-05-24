package com.quiz.service;

import com.quiz.entity.User;
import com.quiz.entity.UserRole;
import com.quiz.repo.RoleRepository;
import com.quiz.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User checkUser = this.userRepository.findUserByUsername(user.getUsername());

        if (checkUser!=null){
            throw new Exception("This username already exist!!");
        }else {
            for (UserRole ur:userRoles) {
                this.roleRepository.save(ur.getRole());
            }
            user.getUserRole().addAll(userRoles);
             checkUser =userRepository.save(user);
        }
        return checkUser;
    }

    @Override
    public User findUser(String username) throws Exception {

        User user = this.userRepository.findUserByUsername(username);

        return user;
    }

    @Override
    public void deleteUser(long id) throws Exception {

        this.userRepository.deleteById(id);

    }


}
