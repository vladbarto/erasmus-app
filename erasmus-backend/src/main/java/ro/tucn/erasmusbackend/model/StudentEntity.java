package ro.tucn.erasmusbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="STUDENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "CNP")
/**
 * Current class defines how a faculty should look like
 */
public class StudentEntity extends PersonEntity {

    @Column(name = "MATRICULATIONNUMBER")
    private Integer matriculationNumber;

    @Column(name = "YEAROFSTUDY")
    private int yearOfStudy; // an universitar

    @Column(name = "HASLANGUAGECERTIFICATE")
    private boolean hasLanguageCertificate;

    @Column(name = "GPA")
    private float gpa; // medie generala

    @Column(name = "HASREEXAMINATIONS")
    private boolean hasReexaminations; // hasRestante?
}
