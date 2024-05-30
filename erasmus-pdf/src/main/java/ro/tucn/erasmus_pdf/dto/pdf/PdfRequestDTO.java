package ro.tucn.erasmus_pdf.dto.pdf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tucn.erasmus_pdf.dto.student.StudentRequestDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PdfRequestDTO {

    private StudentRequestDTO student;
}
