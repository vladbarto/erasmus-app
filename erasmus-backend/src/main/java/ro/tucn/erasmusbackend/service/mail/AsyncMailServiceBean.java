package ro.tucn.erasmusbackend.service.mail;

import org.springframework.jms.core.JmsTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import ro.tucn.erasmusbackend.dto.mail.MailRequestDTO;
import ro.tucn.erasmusbackend.dto.mail.MailResponseDTO;
import ro.tucn.erasmusbackend.dto.mail.SendingStatus;
import ro.tucn.erasmusbackend.jms.JmsMessageSenderBase;
import ro.tucn.erasmusbackend.util.MailUtils;

public class AsyncMailServiceBean extends JmsMessageSenderBase<MailRequestDTO> implements MailService {

    public AsyncMailServiceBean(String destination, JmsTemplate jmsTemplate, ObjectMapper objectMapper) {
        super(destination, jmsTemplate, objectMapper);
    }

    @Override
    public MailResponseDTO sendMail(MailRequestDTO mailRequestDTO) {
        SendingStatus status = sendMessage(mailRequestDTO);

        return MailUtils.getMailResponseDTO(mailRequestDTO, status);
    }
}
