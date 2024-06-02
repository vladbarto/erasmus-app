package ro.tucn.erasmusbackend.dto.pdf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.io.ByteArrayResource;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PdfResponseDTO {

    private ByteArrayResource pdfContent;
    private String message;
    private String status;
}
