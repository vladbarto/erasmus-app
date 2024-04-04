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
@Table(name="FACULTY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacultyEntity {
    @Id
    @Column(name = "FACULTYCODE")
    private int facultyCode;

    @Column(name = "NAME")
    private String name;

    @Column(name = "UNIVERSITYCODE")
    private String universityCode;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "COMPOSITEKEY")
    private String compositeKey;
}
