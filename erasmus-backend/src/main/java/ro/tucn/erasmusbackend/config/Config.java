package ro.tucn.erasmusbackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.tucn.erasmusbackend.mapper.AnnouncementMapper;
import ro.tucn.erasmusbackend.mapper.BareSubjectMapper;
import ro.tucn.erasmusbackend.mapper.ChefMapper;
import ro.tucn.erasmusbackend.repository.AnnouncementRepository;
import ro.tucn.erasmusbackend.repository.BareSubjectRepository;
import ro.tucn.erasmusbackend.repository.ChefRepository;
import ro.tucn.erasmusbackend.service.*;

@Configuration
public class Config {

    @Bean
    public ChefService chefServiceBean(
            ChefRepository chefRepository,
            ChefMapper chefMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new ChefServiceBean(chefRepository, chefMapper, applicationName);
    }

    @Bean
    public BareSubjectService bareSubjectService(
            BareSubjectRepository bareSubjectRepository,
            BareSubjectMapper bareSubjectMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new BareSubjectServiceBean(bareSubjectRepository, bareSubjectMapper, applicationName);
    }

    @Bean
    public AnnouncementService announcementServiceBean(
            AnnouncementRepository announcementRepository,
            AnnouncementMapper announcementMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new AnnouncementServiceBean(announcementRepository, announcementMapper, applicationName);
    }
}