package com.practice.bookpopulationservice.controller;

import com.practice.bookpopulationservice.model.BookInfo;
import com.practice.bookpopulationservice.service.BookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book-info")
    public List<BookInfo> getBookInfoByIsbn(@RequestParam String isbn) {
        return bookService.getBookInfoByIsbn(isbn);
    }
    @GetMapping("/book-info-author")
    public List<BookInfo> getBookInfoByAuthor(@RequestParam String author) {
        return bookService.getBookInfoByAuthor(author);
    }

    @GetMapping("/book-info-genre")
    public List<BookInfo> getBookInfoByGenre(@RequestParam String genre) {
        return bookService.getBookInfoByGenre(genre);
    }
}
