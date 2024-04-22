package com.esdproject.academiq.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {
        try {
            var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

            // Check if the current password is correct
            if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
                throw new IllegalStateException("Wrong password");
            }

            // Check if the two new passwords are the same
            if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
                throw new IllegalStateException("Passwords do not match");
            }

            // Update the password
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));

            // Save the new password
            repository.save(user);

            logger.info("Password changed successfully for user: {}", user.getUsername());
        } catch (Exception e) {
            logger.error("Error occurred while changing password", e);
            throw e; // Rethrow the exception for handling at the controller level or other higher layers
        }
    }
}
