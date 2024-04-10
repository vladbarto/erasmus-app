package ro.tucn.erasmusbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
/**
 * Controls the login of a user
 */
@Slf4j
@RestController
@RequestMapping("/auth/v1")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/login")
    @Operation(summary = "Login attempt")
    @ApiResponse(responseCode = "201", description = "Logged in successfully")
    public ResponseEntity<Void> login() {
        log.info("Login request detected...");

        return ResponseEntity.ok().build();
    }
}
