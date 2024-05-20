package ro.tucn.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import ro.tucn.jms.MailMessageReceiverBean;
import ro.tucn.jms.MessageReceiver;
import ro.tucn.service.mail.MailService;
import ro.tucn.service.mail.MailServiceBean;

@Configuration
public class Config {
    @Bean
    public MailService mailService(JavaMailSender javaMailSender) {
        return new MailServiceBean(javaMailSender);
    }

    @Bean
    public MessageReceiver mailMessageReceiver(MailService mailService, ObjectMapper objectMapper) {
        return new MailMessageReceiverBean(mailService, objectMapper);
    }
}
