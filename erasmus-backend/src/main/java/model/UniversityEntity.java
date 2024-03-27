package model;

import jakarta.persistence.Entity;
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
    private String universityCode;
    private String name; // TODO: add this to documentation
    private String city;
    private String country;
    private List<Integer> facultyCodes;
}
