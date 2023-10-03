package com.bookworm.bookwormrecommender.User;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    @ElementCollection
    private Set<String> favoriteBooks = new HashSet<>();

    @ElementCollection
    private Set<String> favoriteGenres = new HashSet<>();

    @ElementCollection
    private Set<String> favoriteAuthors = new HashSet<>();

    public User(Long id, String username, String password, String email, Set<String> favoriteBooks, Set<String> favoriteGenres, Set<String> favoriteAuthors) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.favoriteBooks = favoriteBooks;
        this.favoriteGenres = favoriteGenres;
        this.favoriteAuthors = favoriteAuthors;
    }

    public User(String username, String password, String email, Set<String> favoriteBooks, Set<String> favoriteGenres, Set<String> favoriteAuthors) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.favoriteBooks = favoriteBooks;
        this.favoriteGenres = favoriteGenres;
        this.favoriteAuthors = favoriteAuthors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getFavoriteBooks() {
        return favoriteBooks;
    }

    public void setFavoriteBooks(Set<String> favoriteBooks) {
        this.favoriteBooks = favoriteBooks;
    }

    public Set<String> getFavoriteGenres() {
        return favoriteGenres;
    }

    public void setFavoriteGenres(Set<String> favoriteGenres) {
        this.favoriteGenres = favoriteGenres;
    }

    public Set<String> getFavoriteAuthors() {
        return favoriteAuthors;
    }

    public void setFavoriteAuthors(Set<String> favoriteAuthors) {
        this.favoriteAuthors = favoriteAuthors;
    }
}
