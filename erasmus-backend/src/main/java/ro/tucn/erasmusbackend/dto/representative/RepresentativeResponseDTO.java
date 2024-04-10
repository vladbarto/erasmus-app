package ro.tucn.erasmusbackend.dto.representative;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;
import ro.tucn.erasmusbackend.model.Type;

/**
 * Server's response to the client
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepresentativeResponseDTO extends PersonResponseDTO {

    private String titles;
    private Type type;
}
