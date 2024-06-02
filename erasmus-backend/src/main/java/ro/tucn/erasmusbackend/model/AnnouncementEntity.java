package ro.tucn.erasmusbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="ANNOUNCEMENT")
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
/**
 * Current class defines how an announcement should look like
 */
public class AnnouncementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID announcementId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "REPRESENTATIVEID")
    private UUID representativeId;

    @Column(name = "UNIVERSITYCODE")
    private String universityCode;
}
