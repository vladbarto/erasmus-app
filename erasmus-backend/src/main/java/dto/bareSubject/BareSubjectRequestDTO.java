package dto.bareSubject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BareSubjectRequestDTO {
    private Integer CAENSubject;
    private String compositeKey;
    private String description;
}
