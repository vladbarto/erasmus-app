package ro.tucn.erasmusbackend.service.pdf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import ro.tucn.erasmusbackend.dto.pdf.PdfRequestDTO;
import ro.tucn.erasmusbackend.dto.pdf.PdfResponseDTO;
import ro.tucn.erasmusbackend.resttemplate.RestTemplateBase;

@Slf4j
public class SyncPdfServiceBean extends RestTemplateBase<PdfRequestDTO, PdfResponseDTO> implements PdfService {

    private final String url;

    public SyncPdfServiceBean(String url, RestTemplate restTemplate) {
        super(restTemplate);
        this.url = url;
    }

    @Override
    public PdfResponseDTO generatePdf(PdfRequestDTO pdfRequestDTO) {
        return postForEntity(url, pdfRequestDTO);
    }

    @Override
    public Class<PdfResponseDTO> getResponseType() {
        return PdfResponseDTO.class;
    }

    @Override
    public String getExceptionMessage(PdfRequestDTO pdfRequestDTO) {
        return String.format("%s ---> (FAIL)", pdfRequestDTO.getStudent().getName());
    }
}
