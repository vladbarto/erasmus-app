package ro.tucn.erasmusbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="UNIQUESUBJECT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Current class defines how a Unique subject should look like.
 * A unique subject is one bare subject, but particularised for a specific faculty
 */
public class UniqueSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "UNIVERSITYCODE")
    private String universityCode;

    @Column(name = "FACULTYCODE")
    private UUID facultyCode;

    @Column(name = "CAENSUBJECT")
    private int CAENSubject;

    @Column(name = "ECTSCREDITS")
    private float ECTSCredits;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SUBJECTSTUDYYEAR")
    private int subjectStudyYear;
}
