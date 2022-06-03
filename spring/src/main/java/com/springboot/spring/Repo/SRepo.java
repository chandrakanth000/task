package com.springboot.spring.Repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.spring.Model.StudentM;

@Repository
@Transactional
public class SRepo extends JpaRepository<StudentM,Integer>{
    
}
