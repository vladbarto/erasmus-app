package ro.tucn.erasmusbackend.dto.faculty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacultyResponseDTO {
    private UUID facultyCode;
    private String name;
    private String universityCode;
    private String description;
    private String compositeKey;
}
