package ro.tucn.erasmusbackend.dto.representative;

import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;
import ro.tucn.erasmusbackend.model.Type;


public class RepresentativeResponseDTO extends PersonResponseDTO {
    private String titles;
    private Type type;
}
