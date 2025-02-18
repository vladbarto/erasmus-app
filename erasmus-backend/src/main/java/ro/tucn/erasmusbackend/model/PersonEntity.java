package ro.tucn.erasmusbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.UUID;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="PERSON")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Current class defines how a person should look like.
 * Here things become interesting, because person is to be inherited by Student and Representative.
 */
public class PersonEntity {

    @Column(name="USERID")
    private UUID userId;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID personId;

    @Column(name = "CNP")
    /**
     * This attribute (equivalent of Social Security Number - for US developers) uniquely identifies a person.
     * Hence, it can uniquely identify a Student or a Representative
     */
    private String CNP;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @Column(name = "DATEOFBIRTH")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
