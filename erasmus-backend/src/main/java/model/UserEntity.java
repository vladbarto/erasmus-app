package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private UUID username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private String universityCode;
    private int facultyCode;
    private String country;
    private String city;
    private String role; // asta ii statutul
}
