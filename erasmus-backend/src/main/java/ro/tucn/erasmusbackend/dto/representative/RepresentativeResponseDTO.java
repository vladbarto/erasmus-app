package ro.tucn.erasmusbackend.dto.representative;

import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;
import ro.tucn.erasmusbackend.model.Type;

import java.util.UUID;

public class RepresentativeResponseDTO extends PersonResponseDTO {
    private UUID representativeId;
    private String titles;
    private Type type;
}
