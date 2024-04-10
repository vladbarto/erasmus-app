package ro.tucn.erasmusbackend.dto.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Client's request to the server
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequestDTO {
    private String CNP;
    private String name;
}
