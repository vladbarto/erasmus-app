package ro.tucn.erasmusbackend.dto.uniqueSubject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Server's response to the client
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniqueSubjectResponseDTO {

    private UUID id;
    private String universityCode;
    private UUID facultyCode;
    private int CAENSubject;
    private float ECTSCredits;
    private String name;
    private int subjectStudyYear;
}
