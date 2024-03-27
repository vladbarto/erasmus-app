package dto.representative;

import dto.username.UserResponseDTO;

import java.util.UUID;

public class RepresentativeResponseDTO extends UserResponseDTO {
    private UUID representativeId;
    private String titles;
}
