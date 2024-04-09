package ro.tucn.erasmusbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="REPRESENTATIVE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "CNP")
public class RepresentativeEntity extends PersonEntity {

    @Column(name = "REPRESENTATIVEID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID representativeId;

    @Column(name = "TITLES")
    private String titles; // conf. univ. prof. dr. ...

    @Column(name = "TYPE") // Secretary, Teacher
    @Enumerated(EnumType.STRING)
    private Type type;
}
