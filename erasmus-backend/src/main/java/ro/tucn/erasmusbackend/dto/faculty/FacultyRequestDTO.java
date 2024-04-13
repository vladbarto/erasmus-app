package ro.tucn.erasmusbackend.dto.faculty;

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
public class FacultyRequestDTO {

    private String name;
    private String universityCode;
    private String description;
    private String compositeKey;
}
