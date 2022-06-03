package com.springboot.spring.maintainance;


import com.springboot.spring.Model.BookM;
import java.util.List;

public class BookMain {
    public interface BookService {
	
        public List<BookM> findBooks();
        
        public BookM findById(int id);
        
        public void save(BookM book);
        
    
}
