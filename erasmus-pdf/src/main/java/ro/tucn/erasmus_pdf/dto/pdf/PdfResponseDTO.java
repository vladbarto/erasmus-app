package ro.tucn.erasmus_pdf.dto.pdf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PdfResponseDTO {

    private byte[] pdfContent;
    private String message;
    private String status;
}
