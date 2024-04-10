package ro.tucn.erasmusbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="FACULTY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Current class defines how a student should look like
 */
public class FacultyEntity {

    @Id
    @Column(name = "FACULTYCODE")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID facultyCode;

    @Column(name = "NAME")
    private String name;

    @Column(name = "UNIVERSITYCODE")
    private String universityCode;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "COMPOSITEKEY")
    private String compositeKey;
}
