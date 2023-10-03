package com.bookworm.bookwormrecommender.User;

public class UserRegistrationDTO {
    private String username;
    private String password;
    private String email;

    public UserRegistrationDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getNewUserUsername() {
        return username;
    }

    public void setNewUserUsername(String username) {
        this.username = username;
    }

    public String getNewUserPassword() {
        return password;
    }

    public void setNewUserPassword(String password) {
        this.password = password;
    }

    public String getNewUserEmail() {
        return email;
    }

    public void setNewUserEmail(String email) {
        this.email = email;
    }
}
