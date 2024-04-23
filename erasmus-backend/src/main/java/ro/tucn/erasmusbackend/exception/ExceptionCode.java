package ro.tucn.erasmusbackend.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Possible exceptions
 */
@Getter
@RequiredArgsConstructor
public enum ExceptionCode {
    ERR001_CHEF_NOT_FOUND("Chef with ID %s not found"),
    ERR002_USERNAME_NOT_FOUND("Username %s not found"),
    ERR099_INVALID_CREDENTIALS("Invalid credentials.");

    private final String message;
}
