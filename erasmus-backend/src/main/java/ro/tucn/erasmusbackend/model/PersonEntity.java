package ro.tucn.erasmusbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="PERSON")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PersonEntity {

    @OneToOne
    private UserEntity user;

    @Id
    @Column(name = "CNP")
    private String CNP;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @Column(name = "DATEOFBIRTH")
    private Date dateOfBirth;

    @Column(name = "UNIVERSITYCODE")
    private String universityCode;

    @Column(name = "FACULTYCODE")
    private UUID facultyCode;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;
}
