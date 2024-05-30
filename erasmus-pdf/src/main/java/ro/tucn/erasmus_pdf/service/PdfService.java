package ro.tucn.erasmus_pdf.service;

import ro.tucn.erasmus_pdf.dto.pdf.PdfRequestDTO;
import ro.tucn.erasmus_pdf.dto.pdf.PdfResponseDTO;

public interface PdfService {

    PdfResponseDTO generatePdf(PdfRequestDTO pdfRequestDTO);
}
