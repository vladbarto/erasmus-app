package ro.tucn.erasmusbackend.dto.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

/**
 * Server's response to the client
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponseDTO {

    private String CNP;
    private String name;
    private String phoneNumber;
    private Date dateOfBirth;
    private String universityCode;
    private UUID facultyCode;
    private String country;
    private String city;
}
