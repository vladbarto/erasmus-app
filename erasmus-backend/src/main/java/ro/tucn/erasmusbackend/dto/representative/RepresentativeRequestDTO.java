package ro.tucn.erasmusbackend.dto.representative;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tucn.erasmusbackend.dto.person.PersonRequestDTO;
import ro.tucn.erasmusbackend.model.Type;

/**
 * Client's request to the server
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepresentativeRequestDTO extends PersonRequestDTO {

    private Type type;
}
