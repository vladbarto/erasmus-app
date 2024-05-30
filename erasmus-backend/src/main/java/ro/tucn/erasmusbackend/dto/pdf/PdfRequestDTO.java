package ro.tucn.erasmusbackend.dto.pdf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tucn.erasmusbackend.dto.student.StudentRequestDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PdfRequestDTO {

    private StudentRequestDTO student;
}
