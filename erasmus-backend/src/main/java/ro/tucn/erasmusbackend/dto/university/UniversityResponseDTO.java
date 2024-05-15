package ro.tucn.erasmusbackend.dto.university;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * Server's response to the client
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniversityResponseDTO {

    private String universityCode;
    private String name; // TODO: add this to documentation
    private String city;
    private String country;
}
