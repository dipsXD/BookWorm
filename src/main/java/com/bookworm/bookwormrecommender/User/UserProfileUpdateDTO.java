package com.bookworm.bookwormrecommender.User;

public class UserProfileUpdateDTO {
    private String username;
    private String email;
    private String favoriteBooks;

    public UserProfileUpdateDTO(String username, String email, String favoriteBooks) {
        this.username = username;
        this.email = email;
        this.favoriteBooks = favoriteBooks;
    }

    public String getUserUsername() {
        return username;
    }

    public void setUserUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String email) {
        this.email = email;
    }

    public String getUserFavoriteBooks() {
        return favoriteBooks;
    }

    public void setUserFavoriteBooks(String favoriteBooks) {
        this.favoriteBooks = favoriteBooks;
    }
}
