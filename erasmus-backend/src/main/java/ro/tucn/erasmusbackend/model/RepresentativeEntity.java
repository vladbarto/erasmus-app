package ro.tucn.erasmusbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="REPRESENTATIVE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "personId")
/**
 * Current class defines how a representative should look like.
 * Representative = Representing (aka Responsible) Teacher; or a Secretary
 */
public class RepresentativeEntity extends PersonEntity {

    /**
     * titles for a such a person could be "conf. univ. prof. dr. sL. (sef lucrari)"
     */
    @Column(name = "TITLES")
    private String titles; // conf. univ. prof. dr. ...

    @Column(name = "TYPE") // Secretary, Teacher
    @Enumerated(EnumType.STRING)
    private Type type;
}
