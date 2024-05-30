package ro.tucn.erasmusbackend.service.pdf;

import ro.tucn.erasmusbackend.dto.pdf.PdfRequestDTO;
import ro.tucn.erasmusbackend.dto.pdf.PdfResponseDTO;

public interface PdfService {

    PdfResponseDTO generatePdf(PdfRequestDTO pdfRequestDTO);
}
