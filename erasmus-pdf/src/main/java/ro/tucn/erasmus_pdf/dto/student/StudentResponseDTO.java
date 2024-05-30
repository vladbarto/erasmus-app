package ro.tucn.erasmus_pdf.dto.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tucn.erasmus_pdf.dto.person.PersonResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO extends PersonResponseDTO {

    private Integer matriculationNumber;
    private int yearOfStudy;
    private boolean hasCertificateLanguage;
    private float gpa;
    private boolean hasReexaminations;
}