package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class StudentEntity extends UserEntity {
    @Id
    @Column(name = "MATRICULATIONNUMBER")
    private int matriculationNumber;

    @Column(name = "YEAROFSTUDY")
    private int yearOfStudy; // an universitar

    @Column(name = "HASLANGUAGECERTIFICATE")
    private boolean hasLanguageCertificate;

    @Column(name = "GPA")
    private float gpa; // medie generala

    @Column(name = "HASREEXAMINATIONS")
    private boolean hasReexaminations; // hasRestante?
}

