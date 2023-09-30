package com.bookworm.bookwormrecommender.Book;

import com.bookworm.bookwormrecommender.Author.Author;
import com.bookworm.bookwormrecommender.Genre.Genre;
import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private int publicationYear;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Genre genre;
}
