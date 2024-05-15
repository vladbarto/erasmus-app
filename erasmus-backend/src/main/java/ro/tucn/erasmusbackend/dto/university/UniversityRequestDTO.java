package ro.tucn.erasmusbackend.dto.university;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * Client's request to the server
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniversityRequestDTO {

    private String universityCode;
    private String name;
    private String city;
    private String country;
}
