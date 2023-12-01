package com.practice.bookpopulationservice.service;

import com.practice.bookpopulationservice.model.BookInfo;

import java.util.List;

public interface BookService {
    List<BookInfo> getBookInfo(String isbn);
}
