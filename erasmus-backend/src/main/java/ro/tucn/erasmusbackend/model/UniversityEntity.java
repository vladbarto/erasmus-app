package ro.tucn.erasmusbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name="UNIVERSITY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Current class defines how a university should look like
 */
public class UniversityEntity {
    @Id
    @Column(name = "UNIVERSITYCODE")
    private String universityCode;

    @Column(name = "NAME")
    private String name; // TODO: add this to documentation

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "FACULTYCODES")
    @ElementCollection
    private List<Integer> facultyCodes;
}
