package ro.tucn.erasmusbackend.controller;

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
    public ResponseEntity<Void> login() {
        log.info("Login request detected...");

        return ResponseEntity.ok().build();
    }
}
