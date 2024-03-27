package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name="USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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
    private List<Integer> facultyCodes;
}
