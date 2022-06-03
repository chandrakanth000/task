package com.springboot.spring.Controller;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.spring.maintainance.StudentMain;
import com.springboot.spring.Model.StudentM;

@RestController
@RequestMapping("student")
public class Student {

    org.slf4j.Logger log = LoggerFactory.getLogger(Student.class);

	@Autowired	
    private StudentMain studM;
	
	@PutMapping(value="/myStudent",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)  {
		
		try {
			studM.save(student);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@GetMapping(value="/allstudents",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> getStudents(
			@RequestParam(defaultValue="0") Integer pageNo,
			@RequestParam(defaultValue="3") Integer pageSize,
			@RequestParam(defaultValue="id") String sortBy)
			
			
			 throws ResourceNotFoundException{
		
		
		
		List<Student> students = studM.getStudents(pageNo, pageSize, sortBy);
		
		return new ResponseEntity<List<Student>>(students, new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudentById(@PathVariable int id) throws ResourceNotFoundException{
		
		                
	Student	student = studM.getStudentById(id).orElseThrow(()-> new ResourceNotFoundException("Student resource not found"));
	
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		
	}
	
	@PostMapping(value="/upstudent/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@PathVariable int id ,@RequestBody Student student){
		
		Optional<Student> latStudent = studM.getStudentById(id);
		
	     latStudent.get().setName(student.getName());
		
		studM.save(latStudent.get());
		
	
		log.info("Updating");
		return new ResponseEntity<Student>(latStudent.get(), HttpStatus.OK);
		
	}
    
}
