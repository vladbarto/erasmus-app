package ro.tucn.erasmusbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "BARESUBJECT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Current class defines how a bare subject should look like.
 * A bare subject is a database with generic (common) subjects for whole Europe.
 */
public class BareSubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "CAENSUBJECT")
    private Integer CAENSubject;

    @Column(name = "COMPOSITEKEY")
    private String compositeKey;

    @Column(name = "DESCRIPTION")
    private String description;
}
