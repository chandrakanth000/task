package com.springboot.spring.maintainance;



import java.util.List;
import javax.transaction.Transactional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.spring.Model.BookM;
import com.springboot.spring.Repo.Brepo;
com.springboot.spring.Model.BookM;

@Service
@Transactional
public class BookMainImpl {
    @Autowired
	private BRepo bookr;
	
	
	
	@Override
	public List<BookM> findBooks() {
		
		List<BookM> books = new ArrayList<BookM>();
		
		books = bookr.findAll();
		return books;
	}

	

	@Override
	public void save(BookM book) {
	bookr.save(book);
		
	}



	@Override
	public BookM findById(int id) {
		// TODO Auto-generated method stub

	
		return null;
	}


}
