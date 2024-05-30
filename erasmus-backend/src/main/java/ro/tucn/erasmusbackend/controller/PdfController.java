package ro.tucn.erasmusbackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.tucn.erasmusbackend.dto.pdf.PdfRequestDTO;
import ro.tucn.erasmusbackend.dto.pdf.PdfResponseDTO;
import ro.tucn.erasmusbackend.service.pdf.PdfService;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/pdf/v1")
@RequiredArgsConstructor
public class PdfController {

    private final PdfService syncPdfServiceBean;

    @PostMapping("sync")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PdfResponseDTO> generateSyncPdf(@RequestBody PdfRequestDTO pdfRequestDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) authentication.getPrincipal();
//      pdfRequestDTO.setFrom(email);
        return new ResponseEntity<>(
                syncPdfServiceBean.generatePdf(pdfRequestDTO),
                HttpStatus.OK
        );
    }
}
