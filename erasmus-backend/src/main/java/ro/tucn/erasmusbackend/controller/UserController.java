package ro.tucn.erasmusbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.tucn.erasmusbackend.dto.user.UserRequestDTO;
import ro.tucn.erasmusbackend.dto.user.UserResponseDTO;
import ro.tucn.erasmusbackend.service.user.UserService;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/user/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/info")
    public ResponseEntity<UserResponseDTO> getLoggedUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();

        return new ResponseEntity<>(
                userService.findByUsername(username),
                HttpStatus.OK
        );
    }

    @PostMapping("/one")
    @Operation(summary = "User Registration")
    @ApiResponse(responseCode = "201", description = "User successfully registered",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDTO.class))})
    public ResponseEntity<UserResponseDTO> saveUser(
            @RequestBody UserRequestDTO userRequestDTO
    ) {
        return new ResponseEntity<>(
                userService.save(userRequestDTO),
                HttpStatus.CREATED
        );
    }
}