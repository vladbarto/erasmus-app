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
public class BareSubjectEntity {
    private int CAENSubject;
    private String compositeKey;
    private String description;
}
