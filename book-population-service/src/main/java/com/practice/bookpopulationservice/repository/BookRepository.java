package com.practice.bookpopulationservice.repository;

import com.practice.bookpopulationservice.model.BookInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<BookInfo, String> {
}
