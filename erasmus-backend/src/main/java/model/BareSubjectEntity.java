package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BARESUBJECT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BareSubjectEntity {
    @Id
//    @Column(name = "CAENSUBJECT")
    private Integer CAENSubject;

    @Column(name = "COMPOSITEKEY")
    private String compositeKey;

    @Column(name = "DESCRIPTION")
    private String description;
}
