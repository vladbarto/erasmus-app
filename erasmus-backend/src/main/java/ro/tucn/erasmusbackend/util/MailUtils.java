package ro.tucn.erasmusbackend.util;

import lombok.experimental.UtilityClass;
import ro.tucn.erasmusbackend.dto.mail.MailRequestDTO;
import ro.tucn.erasmusbackend.dto.mail.MailResponseDTO;
import ro.tucn.erasmusbackend.dto.mail.SendingStatus;

@UtilityClass
public class MailUtils {

    public MailResponseDTO getMailResponseDTO(MailRequestDTO mailRequestDTO, SendingStatus status) {
        return MailResponseDTO.builder()
                .from(mailRequestDTO.getFrom())
                .to(mailRequestDTO.getTo())
                .status(status)
                .build();
    }
}

