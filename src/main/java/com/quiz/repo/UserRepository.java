package com.quiz.repo;

import com.quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User ,Long> {

     User findUserByUsername(String username);

     User findUserById(long id);

     @Override
     void deleteById(Long id);
}
