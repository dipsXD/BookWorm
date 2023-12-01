package com.practice.bookpopulationservice.repository;

import com.practice.bookpopulationservice.model.BookInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookInfo, String> {
}
