package ro.tucn.service.mail;

import ro.tucn.dto.mail.MailRequestDTO;
import ro.tucn.dto.mail.MailResponseDTO;

public interface MailService {

    MailResponseDTO sendMail(MailRequestDTO mailRequestDTO);
}
