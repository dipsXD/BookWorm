package com.bookworm.bookwormrecommender.Book;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BookController {
    @PostMapping(path = "/api/parseJson")
    public void parseJson(@RequestBody BookJSON bookJSON) {
        // Use the parsed data in yourModel
        System.out.println("Field 1: " + bookJSON.getTitle());
        System.out.println("Field 2: " + bookJSON.getAuthor());
    }
}
