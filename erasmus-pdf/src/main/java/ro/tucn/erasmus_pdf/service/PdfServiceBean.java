package ro.tucn.erasmus_pdf.service;

import com.itextpdf.layout.element.Paragraph;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ro.tucn.erasmus_pdf.dto.pdf.PdfRequestDTO;
import ro.tucn.erasmus_pdf.dto.pdf.PdfResponseDTO;
import ro.tucn.erasmus_pdf.util.PdfUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;


@Slf4j
@RequiredArgsConstructor
public class PdfServiceBean implements PdfService {

    @Override
    public PdfResponseDTO generatePdf(PdfRequestDTO pdfRequestDTO) {
        PdfResponseDTO response = new PdfResponseDTO();
        try {
            String pdfContent = PdfUtils.getPdf(pdfRequestDTO);
            byte[] pdfBytes = generatePdf(pdfContent);
            response.setPdfContent(pdfBytes);
            response.setMessage("PDF generated successfully");
            response.setStatus("SUCCESS");
        } catch (Exception e) {
            log.error("Error generating PDF: ", e);
            response.setMessage("Error generating PDF");
            response.setStatus("FAILURE");
        }
        return response;
    }

    private byte[] generatePdf(String pdfContent) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        document.add(new Paragraph(pdfContent));

        document.close();
        return baos.toByteArray();
    }
}
