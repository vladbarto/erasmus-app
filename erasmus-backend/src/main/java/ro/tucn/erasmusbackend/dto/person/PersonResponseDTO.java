package ro.tucn.erasmusbackend.dto.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponseDTO {
    private String CNP;
    private String name;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String universityCode;
    private UUID facultyCode;
    private String country;
    private String city;
}
