package ro.tucn.erasmusbackend.dto.uniqueSubject;

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
public class UniqueSubjectRequestDTO {

    private String universityCode;
    private int facultyCode;
    private float ECTSCredits;
    private String name;
    private int subjectStudyYear;
}
