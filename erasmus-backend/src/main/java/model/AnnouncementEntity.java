package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementEntity {
    private int announcementId;
    private String title;
    private String description;
    private int representativeId;
    private String universityCode;
}
