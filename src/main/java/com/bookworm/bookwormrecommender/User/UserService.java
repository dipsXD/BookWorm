package com.bookworm.bookwormrecommender.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // If using Spring Security for password encoding

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserRegistrationDTO registrationDTO) {
        // Implement user registration logic here
        // Create a new User entity and save it to the database
        User user = new User();
        user.setUsername(registrationDTO.getNewUserUsername());
        user.setPassword(passwordEncoder.encode(registrationDTO.getNewUserPassword())); // Encode the password
        user.setEmail(registrationDTO.getNewUserEmail());

        // Perform additional validation, such as checking if the username or email is already taken

        return userRepository.save(user);
    }

    public User loginUser(UserLoginDTO loginDTO) {
        // Implement user login logic here
        // Retrieve the user by username from the database
        User user = userRepository.findByUsername(loginDTO.getUsername());

        if (user != null && passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            // Passwords match, user is authenticated
            return user;
        } else {
            // Authentication failed
            return null;
        }
    }

    public User updateUserProfile(Long userId, UserProfileUpdateDTO profileDTO) {
        // Implement logic to update user profile
        // Retrieve the user by ID from the database
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            // Update user profile information based on profileDTO
            user.setUsername(profileDTO.getUsername());
            user.setEmail(profileDTO.getEmail());
            user.setFavoriteBooks(profileDTO.getFavoriteBooks());

            // Save the updated user to the database
            return userRepository.save(user);
        } else {
            // User not found
            return null;
        }
    }

    // Add more methods for user-related operations as needed
}

