package ro.tucn.erasmusbackend.dto.bareSubject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Server's response to the client
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BareSubjectResponseDTO {

    private UUID id;
    private Integer CAENSubject;
    private String compositeKey;
    private String description;
}
