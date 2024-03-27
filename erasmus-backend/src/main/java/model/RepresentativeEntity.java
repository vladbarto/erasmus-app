package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@Table(name="USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepresentativeEntity extends UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID representativeId;

    @Column(name = "TITLES")
    private String titles;
}
