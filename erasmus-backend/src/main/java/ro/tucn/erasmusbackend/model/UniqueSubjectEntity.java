package ro.tucn.erasmusbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "UNIVERSITYCODE")
    private String universityCode;

    @Column(name = "FACULTYCODE")
    private int facultyCode;

    @Column(name = "CAENSUBJECT")
    private int CAENSubject;

    @Column(name = "ECTSCREDITS")
    private float ECTSCredits;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SUBJECTSTUDYYEAR")
    private int subjectStudyYear;
}
