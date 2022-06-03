package com.springboot.spring.Repo;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.spring.Model.BookM;

@Repository
@Transactional
public class Brepo extends JpaRepository<BookM, Integer>{
    
}
