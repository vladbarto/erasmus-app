package ro.tucn.erasmusbackend.dto.pdf;

import lombok.*;
import ro.tucn.erasmusbackend.dto.student.StudentRequestDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PdfRequestDTO {

    private StudentRequestDTO student;
}
