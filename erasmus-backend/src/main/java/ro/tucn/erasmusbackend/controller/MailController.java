package ro.tucn.erasmusbackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.tucn.erasmusbackend.dto.mail.MailResponseDTO;
import ro.tucn.erasmusbackend.dto.mail.MailRequestDTO;
import ro.tucn.erasmusbackend.service.mail.MailService;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/mail/v1")
@RequiredArgsConstructor
public class MailController {

    private final MailService syncMailServiceBean;

    @PostMapping("sync")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MailResponseDTO> sendSyncMail(@RequestBody MailRequestDTO mailRequestDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) authentication.getPrincipal();
        mailRequestDTO.setFrom(email);

        return new ResponseEntity<>(
                syncMailServiceBean.sendMail(mailRequestDTO),
                HttpStatus.OK
        );
    }
}