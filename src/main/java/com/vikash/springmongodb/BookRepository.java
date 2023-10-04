package com.vikash.springmongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,Integer>
{

	public Book findById(int id);
}
