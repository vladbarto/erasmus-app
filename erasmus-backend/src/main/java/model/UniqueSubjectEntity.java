package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniqueSubjectEntity {
    private String universityCode;
    private int facultyCode;
    private int CAENSubject;
    private float ECTSCredits;
    private String name;
    private int subjectStudyYear;
}
