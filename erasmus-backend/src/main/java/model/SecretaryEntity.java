package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class SecretaryEntity {
    @Id
    @Column(name = "SECRETARYID")
    private int secretaryId;

    @Column(name = "USERNAME")
    private UUID username;

    @Column(name = "TITLES")
    private String titles;
}
