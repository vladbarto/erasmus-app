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
public class StudentEntity extends UserEntity {
    private int matriculationNumber;
    private int yearOfStudy; // an universitar
    private boolean hasLanguageCertificate;
    private float gpa; // medie generala
    private boolean hasReexaminations; // hasRestante?
}

