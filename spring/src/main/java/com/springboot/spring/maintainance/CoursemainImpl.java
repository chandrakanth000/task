package com.springboot.spring.maintainance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.spring.Repo.CRepo;
import com.springboot.spring.Model.courseM;
public class CoursemainImpl implements CourseMain{
    @Autowired
	private CRepo courser;
	@Override
	public void save(courseM course) {
		
		courser.save(course);
		
	}
	public List<courseM> getCourses() {
		List<courseM> courses = courser.findAll();
		return courses;
	}       
}
