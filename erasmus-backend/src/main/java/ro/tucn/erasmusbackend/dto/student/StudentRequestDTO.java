package ro.tucn.erasmusbackend.dto.student;

import lombok.*;
import ro.tucn.erasmusbackend.dto.person.PersonRequestDTO;

/**
 * Client's request to the server
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO extends PersonRequestDTO {

    private int yearOfStudy;
    private boolean hasCertificateLanguage;
    private float gpa;
    private boolean hasReexaminations;
}
