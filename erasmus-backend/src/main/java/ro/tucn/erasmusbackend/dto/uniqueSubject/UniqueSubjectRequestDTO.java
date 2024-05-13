package ro.tucn.erasmusbackend.dto.uniqueSubject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Client's request to the server
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniqueSubjectRequestDTO {

    private String universityCode;
    private UUID facultyCode;
    private int CAENSubject;
    private float ECTSCredits;
    private String name;
    private int subjectStudyYear;
}
