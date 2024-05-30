package ro.tucn.erasmus_pdf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.tucn.erasmus_pdf.service.PdfService;
import ro.tucn.erasmus_pdf.service.PdfServiceBean;

@Configuration
public class Config {

    @Bean
    public PdfService pdfService() { return new PdfServiceBean(); }
}
