package model;

import jakarta.persistence.Entity;
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
    private int secretaryId;
    private UUID username;
    private String titles;
}
