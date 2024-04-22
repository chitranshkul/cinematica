package com.esdproject.academiq.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    private final UserService service;

    @PatchMapping("/change-password")
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ) {
        try {
            service.changePassword(request, connectedUser);
            logger.info("Password changed successfully for user: {}", connectedUser.getName());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Error occurred while changing password for user: {}", connectedUser.getName(), e);
            // Handle the error and return an appropriate response, e.g., ResponseEntity with error message
            return ResponseEntity.internalServerError().build();
        }
    }
}
