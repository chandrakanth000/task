package com.springboot.spring.maintainance;

import java.util.List;
import java.util.Optional;

import com.springboot.spring.Model.StudentM;

public class StudentMain {
    public void save(StudentM latStudent);
	
	public Optional<StudentMain> getStudentById(int id);

	public List<StudentM> getStudents(Integer pageNo, Integer pageSize, String sortBy);

    
}
