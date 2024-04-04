package ro.tucn.erasmusbackend.dto.faculty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacultyRequestDTO {
    private String name;
    private String universityCode;
}
