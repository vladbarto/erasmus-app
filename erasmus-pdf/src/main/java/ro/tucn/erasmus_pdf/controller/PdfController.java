package ro.tucn.erasmus_pdf.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tucn.erasmus_pdf.dto.pdf.PdfRequestDTO;
import ro.tucn.erasmus_pdf.dto.pdf.PdfResponseDTO;
import ro.tucn.erasmus_pdf.service.PdfService;

@Slf4j
@RestController
@RequestMapping("/pdf/v1")
@RequiredArgsConstructor
public class PdfController {

    private final PdfService pdfService;

    @PostMapping("/generator")
    public ResponseEntity<PdfResponseDTO> generatePdf(@RequestBody PdfRequestDTO pdfRequestDTO) {
        PdfResponseDTO responseDTO = pdfService.generatePdf(pdfRequestDTO);

        if ("SUCCESS".equals(responseDTO.getStatus())) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "generated.pdf");

            return new ResponseEntity<>(
                    responseDTO,//.getPdfContent(),
                    headers,
                    HttpStatus.OK
            );
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}