package ro.tucn.erasmusbackend.dto.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tucn.erasmusbackend.dto.person.PersonRequestDTO;

/**
 * Client's request to the server
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO extends PersonRequestDTO {

    private Integer matriculationNumber;
}
