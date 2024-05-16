package com.esdproject.academiq.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {


  private static final Logger logger = LogManager.getLogger(AuthenticationController.class);

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
          @RequestBody RegisterRequest request
  ) {
    // Log a debug message indicating that a registration request is received
    logger.debug("Received registration request: {}", request);
    return ResponseEntity.ok(service.register(request));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
          @RequestBody AuthenticationRequest request
  ) {
    // Log a debug message indicating that an authentication request is received
    logger.debug("Received authentication request: {}", request);
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    try {
      service.refreshToken(request, response);
    } catch (Exception e) {
      // Log an error message if an exception occurs during token refresh
      logger.error("Error occurred during token refresh", e);
      throw e;
    }
  }


}