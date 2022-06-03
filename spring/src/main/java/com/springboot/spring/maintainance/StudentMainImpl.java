package com.springboot.spring.maintainance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.spring.Repo.SRepo;
import com.springboot.spring.Model.StudentM;

@Service
public class StudentMainImpl implements StudentMain{
    
    @Autowired
	private SRepo stuR;
}

    @Override
	public Optional<StudentM> getStudentById(int id) {
	
		return stuR.findById(id);
	}

	@Override
	public void save(StudentM student) {
		
		stuR.save(student);	
	}

    @Override
	public List<StudentM> getStudents(Integer pageNo, Integer pageSize, String sortBy) {
		
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
				
		Page<StudentM> pagedResult = stuR.findAll(paging);
				
				
				
			if(pagedResult.hasContent()) {
				return pagedResult.getContent();
			}\
        
            else {
					return new ArrayList<StudentM>();
			}
	}
