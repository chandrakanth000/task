package com.springboot.spring.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import com.springboot.spring.Model.courseM;

@Repository
@Transactional
public class CRepo extends JpaRepository<courseM,Integer>{
    
}
