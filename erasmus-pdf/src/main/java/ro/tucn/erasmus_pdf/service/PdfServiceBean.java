package ro.tucn.erasmus_pdf.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import ro.tucn.erasmus_pdf.dto.pdf.PdfRequestDTO;
import ro.tucn.erasmus_pdf.dto.pdf.PdfResponseDTO;
import ro.tucn.erasmus_pdf.util.PdfUtils;

@Slf4j
@RequiredArgsConstructor
public class PdfServiceBean implements PdfService {

    @Override
    public PdfResponseDTO generatePdf(PdfRequestDTO pdfRequestDTO) {
        log.info("Received pdf request for {}", pdfRequestDTO.getStudent().getName());
        PdfResponseDTO response = new PdfResponseDTO();
        try {
            String pdfContent = PdfUtils.getPdf(pdfRequestDTO);
            log.debug("Generated HTML content: {}", pdfContent);

            byte[] pdfBytes = PdfUtils.generatePdfFromHtml(pdfContent);
            ByteArrayResource resource = new ByteArrayResource(pdfBytes);
            //response.setPdfContent(resource);
            response.setMessage("PDF generated successfully");
            response.setStatus("SUCCESS");
        } catch (Exception e) {
            log.error("Error generating PDF: ", e);
            response.setMessage("Error generating PDF");
            response.setStatus("FAILURE");
        }
        return response;
    }
}
