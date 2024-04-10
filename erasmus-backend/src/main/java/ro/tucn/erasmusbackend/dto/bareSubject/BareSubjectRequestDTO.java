package ro.tucn.erasmusbackend.dto.bareSubject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Client's request to the server
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BareSubjectRequestDTO {

    private Integer CAENSubject;
    private String compositeKey;
    private String description;
}
