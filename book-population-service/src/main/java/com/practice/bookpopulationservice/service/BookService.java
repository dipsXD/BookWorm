package com.practice.bookpopulationservice.service;

import com.practice.bookpopulationservice.model.BookInfo;

import java.util.List;

public interface BookService {
    List<BookInfo> getBookInfoByIsbn(String isbn);

    List<BookInfo> getBookInfoByAuthor(String author);

    List<BookInfo> getBookInfoByGenre(String genre);
}
