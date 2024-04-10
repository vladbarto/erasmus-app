package ro.tucn.erasmusbackend.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Exception returned for a request: type of exception and timestamp
 */
@Getter
@RequiredArgsConstructor
public class ExceptionBody {

    private final String message;
    private final LocalDateTime timestamp;

    public ExceptionBody(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
