package ro.tucn.erasmus_pdf.dto.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tucn.erasmus_pdf.dto.person.PersonRequestDTO;

/**
 * Client's request to the server
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO extends PersonRequestDTO {

    private int yearOfStudy;
    private boolean hasCertificateLanguage;
    private float gpa;
    private boolean hasReexaminations;
}
