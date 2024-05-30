package ro.tucn.erasmus_pdf.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ro.tucn.erasmus_pdf.dto.pdf.PdfRequestDTO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@UtilityClass
public class PdfUtils {

    private final String PDF_TEMPLATE_LOCATION = "templates.pdf/learning-agreement.html";
    private final String PDF_STUDENT_NAME = "###STUDENT NAME###";
    private final String PDF_STUDENT_DOB = "###DATE OF BIRTH###";
    private final String PDF_STUDENT_SENDING_UNIVERSITY = "###SENDING UNIVERSITY###";

    public String getPdf(PdfRequestDTO pdfRequestDTO) throws IOException {
        String pdfContent = getPdfContent();
        Map<String, String> pdfProperties = getPdfProperties(pdfRequestDTO);

        return pdfProperties.entrySet().stream()
                .reduce(
                        pdfContent,
                        (content, entry) -> content.replace(entry.getKey(), entry.getValue()),
                        (s1, s2) -> s2
                );
    }

    private String getPdfContent() throws IOException {
        Resource resource = new ClassPathResource(PDF_TEMPLATE_LOCATION);

        return IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    private Map<String, String> getPdfProperties(PdfRequestDTO pdfRequestDTO) {
        return Map.ofEntries(
                Map.entry(PDF_STUDENT_NAME, pdfRequestDTO.getStudent().getName()),
                Map.entry(PDF_STUDENT_DOB, pdfRequestDTO.getStudent().getDateOfBirth().toString()),
                Map.entry(PDF_STUDENT_DOB, pdfRequestDTO.getStudent().getUniversityCode())
        );
    }
}
