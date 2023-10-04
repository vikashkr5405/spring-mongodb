package com.vikash.springmongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookRepository brepo;
	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book)
	{
		brepo.save(book);
		return "Added book with id :" +book.getId();
	}
	
	@GetMapping("/findall")
	public List<Book> getAllBooks()
	{
		return brepo.findAll();
	}
	
	@GetMapping("/findbyid/{id}")
	public Book getBook(@PathVariable int id)
	{
		return brepo.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id)
	{
		brepo.deleteById(id);
		return "Book deleted with id :"+id;
	}
	@PutMapping("/update/{id}")
	public String updateBook(@RequestBody Book book,@PathVariable int id)
	{
		Book b=brepo.findById(id);
		b.setBookName(book.getBookName());
		b.setAuthorName(book.getAuthorName());
		
		brepo.save(b);
		return "Book is updated with Id : "+id;
	}
}
