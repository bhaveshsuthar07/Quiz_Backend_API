package com.quiz.repo;

import com.quiz.entity.FirstTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirstTimeRepository extends JpaRepository<FirstTime,Integer> {

    public FirstTime findById(int id);

}
